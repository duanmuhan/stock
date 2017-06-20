package com.cgs.dao;

import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.TrendMin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrendDao {

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  public void add(TrendMin trendMin){
    redisTemplate.opsForList().leftPush(GraphsRedisKeys.trendKey(trendMin),trendMin.toRedisValue());
  }
}
