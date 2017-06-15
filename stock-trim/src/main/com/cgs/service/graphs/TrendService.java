package com.cgs.service.graphs;

import com.cgs.cache.TrendCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrendService {

  @Autowired
  TrendCache trendCache;
}
