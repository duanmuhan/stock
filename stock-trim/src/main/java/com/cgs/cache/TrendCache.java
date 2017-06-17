package com.cgs.cache;

import com.cgs.dao.TrendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrendCache {

  @Autowired
  private TrendDao trendDao;
}
