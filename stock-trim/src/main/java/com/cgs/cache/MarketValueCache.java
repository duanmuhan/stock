package com.cgs.cache;

import com.cgs.dao.MarketValueDao;
import com.cgs.entity.graphs.MarketValue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarketValueCache {

  private Map<Integer,MarketValue> marketValueCache = new ConcurrentHashMap<>();
  @Autowired
  private MarketValueDao kDao;

  public void put(String stockId){

  }

  private void persistant(MarketValue marketValue){

  }
}
