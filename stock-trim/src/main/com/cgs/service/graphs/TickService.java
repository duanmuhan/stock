package com.cgs.service.graphs;

import com.cgs.cache.TickCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TickService {

  @Autowired
  TickCache tickCache;
}
