package com.cgs.service.graphs;

import com.alibaba.fastjson.JSON;
import com.cgs.amqp.AMQPClient;
import com.cgs.cache.MarketValueCache;
import com.cgs.dao.MarketPriceDao;
import com.cgs.entity.constant.ActiveMQKeys;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.service.graphs.interfaces.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketValueService implements IHandler{

  @Autowired
  private MarketValueCache marketValueCache;
  @Autowired
  private MarketPriceDao marketPriceDao;
  @Autowired
  private AMQPClient amqpClient;

  @Override
  public void handle(MarketPrice marketPrice) {
    if (!marketValueCache.exists(marketPrice) || !marketValueCache.get(marketPrice).equals(marketPrice.toRedisValue())){
      marketValueCache.put(marketPrice);
      marketPriceDao.add(marketPrice);
      amqpClient.sendMessage(ActiveMQKeys.MARKET_PRICE.getContext(), JSON.toJSONString(marketPrice));
    }
  }
}
