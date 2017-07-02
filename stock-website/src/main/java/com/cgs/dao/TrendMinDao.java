package com.cgs.dao;

import com.cgs.entity.constant.TrendPeriod;
import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.TrendMin;
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
public class TrendMinDao {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public List<TrendMin> findMinTrendById(String stockId,long start,long end){
        List<TrendMin> list = doGetTrendById(stockId, TrendPeriod.MIN.getValue(),start,end);
        return list;
    }

    public List<TrendMin> find5MinTrendById(String stockId,long start,long end){
        List<TrendMin> list = doGetTrendById(stockId,TrendPeriod.FIVE_MIN.getValue(),start,end);
        return list;
    }

    private List<TrendMin> doGetTrendById(String stockId,String period,long start,long end){
        List<TrendMin> list = new ArrayList<>();
        String key = GraphsRedisKeys.trendKey(stockId, period);
        long size = redisTemplate.opsForList().size(key) - 1;
        List<String> trendList;
        if (end > size){
            trendList = redisTemplate.opsForList().range(key,start,size);
        }else {
            trendList = redisTemplate.opsForList().range(key,start,end);
        }
        if (!ObjectUtils.isEmpty(trendList)){
            for (String str : trendList){
                TrendMin trendMin = new TrendMin();
                trendMin = trendMin.parseFromMessage(str);
                list.add(trendMin);
            }
        }
        return list;
    }

}
