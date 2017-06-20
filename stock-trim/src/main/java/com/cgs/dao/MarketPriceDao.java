package com.cgs.dao;

import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.MarketPrice;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MarketPriceDao {

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  public void add(MarketPrice marketPrice){
    redisTemplate.opsForList().leftPush(GraphsRedisKeys.marketValueKey(marketPrice),marketPrice.toRedisValue());
  }

  public List<MarketPrice> all(){
    List<MarketPrice> marketPriceList = new ArrayList<>();
    return marketPriceList;
  }
}
