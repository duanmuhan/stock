package com.cgs.cache;

import com.cgs.dao.TickDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TickCache {

  @Autowired
  private TickDao tickDao;
}
