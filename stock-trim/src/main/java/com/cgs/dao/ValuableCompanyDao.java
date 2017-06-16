package com.cgs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValuableCompanyDao {

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

}
