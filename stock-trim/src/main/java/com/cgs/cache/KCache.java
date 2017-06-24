package com.cgs.cache;

import com.cgs.amqp.AMQPClient;
import com.cgs.dao.KDao;
import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class KCache {

  @Autowired
  private KDao kDao;
  @Autowired
  private AMQPClient amqpClient;

  private Map<String,Map<KPeriod,KEntity>> kMap = new ConcurrentHashMap<>();

  public void put(MarketPrice marketPrice){
    Map<KPeriod,KEntity> periodMap;
    if (isExists(marketPrice)){
      periodMap = kMap.get(marketPrice.getStockId());
    }else {
      periodMap = new HashMap<>();
      kMap.put(marketPrice.getStockId(),periodMap);
    }
    generateK(periodMap,marketPrice,KPeriod.MIN);
    generateK(periodMap,marketPrice,KPeriod.FIVE_MIN);
    generateK(periodMap,marketPrice,KPeriod.FIFTEEN_MIN);
    generateK(periodMap,marketPrice,KPeriod.HALF_HOUR);
    generateK(periodMap,marketPrice,KPeriod.HOUR);
  }

  private boolean isExists(MarketPrice marketPrice){
    if (kMap.containsKey(marketPrice.getStockId())){
      return true;
    }
    return false;
  }

  private void persistent(KEntity kEntity){
    kDao.add(kEntity);
  }

  private void persistentUpdate(KEntity kEntity){
    kDao.update(kEntity);
  }

  private void generateK(Map<KPeriod,KEntity> periodMap,MarketPrice marketPrice,KPeriod kPeriod){
    if (ObjectUtils.isEmpty(periodMap)){
      periodMap = new HashMap<>();
      kMap.put(marketPrice.getStockId(),periodMap);
    }else {
      KEntity minK = periodMap.get(kPeriod);
      if (ObjectUtils.isEmpty(minK)){
        minK = new KEntity();
        minK.setStockId(marketPrice.getStockId());
        minK.setOpen(marketPrice.getOpen());
        minK.setClose(marketPrice.getClose());
        minK.setHigh(marketPrice.getHigh());
        minK.setLow(marketPrice.getLow());
        minK.setPeriod(kPeriod);
        minK.setTimestamp(marketPrice.getTimestamp());
        periodMap.put(kPeriod,minK);
      }else {
        if (TimeUtil.isSamePeriod(minK.getTimestamp(),marketPrice.getTimestamp(),kPeriod)){
          if (minK.getHigh() < marketPrice.getHigh()){
            minK.setHigh(marketPrice.getHigh());
          }
          if (minK.getLow() > marketPrice.getLow()){
            minK.setLow(marketPrice.getLow());
          }
          minK.setVolume(minK.getVolume() + marketPrice.getVol());
          persistentUpdate(minK);
        } else {
          persistent(minK);
          periodMap.remove(kPeriod);
          minK = new KEntity();
          minK.setStockId(marketPrice.getStockId());
          minK.setPeriod(kPeriod);
          minK.setVolume(marketPrice.getVol());
          minK.setHigh(marketPrice.getHigh());
          minK.setLow(marketPrice.getLow());
          minK.setOpen(marketPrice.getOpen());
          minK.setClose(marketPrice.getClose());
          minK.setTimestamp(marketPrice.getTimestamp());
          periodMap.put(kPeriod,minK);
        }
      }
      amqpClient.sendMessage(kPeriod.name(),minK.toMessage());
    }
  }

}
