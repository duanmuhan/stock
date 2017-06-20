package com.cgs.dao;

import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.KEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class KDao {

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  public void add(KEntity entity){
    redisTemplate.opsForList().leftPush(GraphsRedisKeys.kDataKey(entity),entity.toRedisValue());
  }

}
