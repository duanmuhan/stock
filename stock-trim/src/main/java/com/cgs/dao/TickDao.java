package com.cgs.dao;

import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.Tick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TickDao {

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  public void add(Tick tick){
    redisTemplate.opsForList().leftPush(GraphsRedisKeys.tickKey(tick),tick.toRedisValue());
  }
}
