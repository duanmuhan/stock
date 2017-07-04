package com.cgs.cache;

import com.cgs.amqp.AMQPClient;
import com.cgs.dao.TrendDao;
import com.cgs.entity.constant.TrendPeriod;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.entity.graphs.TrendMin;
import com.cgs.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@Component
public class TrendCache {

  @Autowired
  private TrendDao trendDao;
  @Autowired
  private AMQPClient amqpClient;

  private Map<String,Map<TrendPeriod,TrendMin>> trendMap = new HashMap<>();

  public void put(MarketPrice marketPrice){
    Map<TrendPeriod,TrendMin> periodMap;
    if (isExists(marketPrice)){
      periodMap = trendMap.get(marketPrice.getStockId());
    }else {
      periodMap = new HashMap<>();
    }
    generateTrend(periodMap,marketPrice,TrendPeriod.MIN);
    generateTrend(periodMap,marketPrice,TrendPeriod.FIVE_MIN);
  }

  private boolean isExists(MarketPrice marketPrice){
    if (trendMap.containsKey(marketPrice.getStockId())){
      return true;
    }
    return false;
  }

  private void generateTrend(Map<TrendPeriod,TrendMin> periodMap,MarketPrice marketPrice,TrendPeriod trendPeriod){
    TrendMin trendMin = periodMap.get(trendPeriod);
    if (ObjectUtils.isEmpty(trendMin)){
      trendMin = new TrendMin();
      trendMin.setStockId(marketPrice.getStockId());
      trendMin.setClose(marketPrice.getClose());
      trendMin.setVwap(marketPrice.getPrice());
      trendMin.setVolume(marketPrice.getVol());
      trendMin.setTrendPeriod(trendPeriod);
      trendMin.setTime(marketPrice.getTimestamp());
      trendDao.update(trendMin);
    }else{
      if (TimeUtil.isSameTrendPeriod(trendMin.getTime(),marketPrice.getTimestamp(),trendPeriod)){
        trendMin.setClose(marketPrice.getClose());
        double vwap = (trendMin.getVwap() * trendMin.getVolume() + marketPrice.getVol() * marketPrice.getPrice())/(trendMin.getVolume() + marketPrice.getVol());
        trendMin.setVwap(vwap);
        trendMin.setVolume(trendMin.getVolume() + marketPrice.getVol());
        trendMin.setTime(marketPrice.getTimestamp());
        trendDao.update(trendMin);
      }else {
        trendDao.add(trendMin);
        periodMap.remove(trendPeriod);
        trendMin = new TrendMin();
        trendMin.setStockId(marketPrice.getStockId());
        trendMin.setClose(marketPrice.getClose());
        trendMin.setVwap(marketPrice.getPrice());
        trendMin.setVolume(marketPrice.getVol());
        trendMin.setTrendPeriod(trendPeriod);
        trendMin.setTime(marketPrice.getTimestamp());
      }
    }
    amqpClient.sendMessage(trendMin.getTrendPeriod().getValue(),trendMin.toMessage());
  }
}
