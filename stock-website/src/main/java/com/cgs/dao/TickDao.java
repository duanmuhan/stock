package com.cgs.dao;

import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.Tick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */
@Repository
public class TickDao {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public List<Tick> findTickListById(String stockId,long start,long end){
        List<Tick> tickList = new ArrayList<>();
        String key = GraphsRedisKeys.tickKey(stockId);
        List<String> list = redisTemplate.opsForList().range(key,start,end);
        if (!ObjectUtils.isEmpty(list)){
            for (String value : list){
                Tick tick = new Tick();
                tick = tick.parseFromMessage(value);
                tickList.add(tick);
            }
        }
        return tickList;
    }

}
