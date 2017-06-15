package com.cgs.entity.model;

public interface RedisSerializer<T,V> {

  V toRedisValue();

  T parseFromRedis(V string);
}
