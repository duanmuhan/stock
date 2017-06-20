package com.cgs.cache;

import com.cgs.dao.KDao;
import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.MarketPrice;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KCache {

  private Map<Integer,Map<KPeriod,KEntity>> kMap = new ConcurrentHashMap<>();
  @Autowired
  private KDao dao;

  public void put(MarketPrice marketValue){

  }

  private void persistent(){

  }
}