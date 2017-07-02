package com.cgs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/2.
 */
@Repository
public class MarketPriceDao {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
}
