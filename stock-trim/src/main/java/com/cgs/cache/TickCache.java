package com.cgs.cache;

import com.cgs.amqp.AMQPClient;
import com.cgs.dao.TickDao;
import com.cgs.entity.constant.ActiveMQKeys;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.entity.graphs.Tick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TickCache {

  @Autowired
  private TickDao tickDao;
  @Autowired
  private AMQPClient amqpClient;
  private Map<String,Tick> tickMap = new ConcurrentHashMap<>();

  public void put(MarketPrice marketPrice){
    Tick tick = new Tick();
    tick.setStockId(marketPrice.getStockId());
    tick.setPrice(marketPrice.getPrice());
    tick.setTimestamp(marketPrice.getTimestamp());
    tick.setVolume(marketPrice.getVol());
    tickDao.add(tick);
    amqpClient.sendMessage(ActiveMQKeys.TICK.getContext(),tick.toMessage());
  }
}
