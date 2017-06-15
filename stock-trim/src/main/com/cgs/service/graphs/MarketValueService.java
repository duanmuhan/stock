package com.cgs.service.graphs;

import com.cgs.cache.MarketValueCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketValueService {

  @Autowired
  MarketValueCache marketValueCache;
}
