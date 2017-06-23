package com.cgs.cache;

import com.cgs.dao.MarketPriceDao;
import com.cgs.entity.graphs.MarketPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MarketValueCache {

  private Map<Integer,MarketPrice> marketValueCache = new ConcurrentHashMap<>();
  @Autowired
  private MarketPriceDao kDao;

  public void put(String stockId){

  }

  private void persistant(MarketPrice marketValue){

  }
}
