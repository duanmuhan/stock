package com.cgs.service.graphs;

import com.cgs.cache.TrendCache;
import com.cgs.entity.graphs.MarketValue;
import com.cgs.service.graphs.interfaces.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrendService implements IHandler {

  @Autowired
  TrendCache trendCache;

  @Override
  public void handle(MarketValue marketValue) {

  }
}
