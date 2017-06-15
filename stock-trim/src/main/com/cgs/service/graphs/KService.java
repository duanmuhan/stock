package com.cgs.service.graphs;

import com.cgs.cache.KCache;
import com.cgs.entity.graphs.MarketValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KService{

  @Autowired
  KCache kCache;

  public void handler(MarketValue marketValue) {

  }
}
