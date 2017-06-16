package com.cgs.service.graphs;

import com.cgs.cache.KCache;
import com.cgs.entity.graphs.MarketValue;
import com.cgs.service.graphs.interfaces.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KService implements IHandler{

  @Autowired
  KCache kCache;

  public void handle(MarketValue marketValue) {
    
  }
}
