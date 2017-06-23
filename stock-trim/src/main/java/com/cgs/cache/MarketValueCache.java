package com.cgs.cache;

import com.cgs.entity.graphs.MarketPrice;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MarketValueCache {

  private Map<String,String> marketValueCache = new ConcurrentHashMap<>();

  public void put(MarketPrice marketPrice){
    marketValueCache.put(marketPrice.getStockId(),marketPrice.toRedisValue());
  }

  public boolean exists(MarketPrice marketPrice){
    return  marketValueCache.containsKey(marketPrice.getStockId());
  }

  public String get(MarketPrice marketPrice){
    return marketValueCache.get(marketPrice.getStockId());
  }
}
