package com.cgs.service.graphs;

import com.cgs.cache.TickCache;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.service.graphs.interfaces.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TickService implements IHandler {

  @Autowired
  TickCache tickCache;

  @Override
  public void handle(MarketPrice marketPrice) {

  }
}
