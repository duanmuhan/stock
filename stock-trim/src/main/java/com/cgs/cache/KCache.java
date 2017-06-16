package com.cgs.cache;

import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.MarketValue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class KCache {

  private Map<Integer,Map<KPeriod,KEntity>> kMap = new ConcurrentHashMap<>();

  public void put(MarketValue marketValue){

  }

  private void persistent(){

  }
}
