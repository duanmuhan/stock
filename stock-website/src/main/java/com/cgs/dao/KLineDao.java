package com.cgs.dao;

import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.constant.redis.GraphsRedisKeys;
import com.cgs.entity.graphs.KEntity;
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
public class KLineDao {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public List<KEntity> findMinKListById(String stockId,long start,long end){
        List<KEntity> entityList = doFindKListById(stockId,KPeriod.MIN.getValue(),start,end);
        return entityList;
    }

    public List<KEntity> find5MinKListById(String stockId,long start,long end){
        List<KEntity> entityList = doFindKListById(stockId,KPeriod.FIVE_MIN.getValue(),start,end);
        return entityList;
    }

    public List<KEntity> find15MinKListById(String stockId,long start,long end){
        List<KEntity> entityList = doFindKListById(stockId,KPeriod.FIFTEEN_MIN.getValue(),start,end);
        return entityList;
    }

    public List<KEntity> find30MinKListById(String stockId,long start,long end){
        List<KEntity> entityList = doFindKListById(stockId,KPeriod.HALF_HOUR.getValue(),start,end);
        return entityList;
    }

    public List<KEntity> findHourKListById(String stockId,long start,long end){
        List<KEntity> entityList = doFindKListById(stockId,KPeriod.HOUR.getValue(),start,end);
        return entityList;
    }

    private List<KEntity> doFindKListById(String stockId,String period,long start,long end){
        List<KEntity> entityList = new ArrayList<>();
        String key = GraphsRedisKeys.kDataKey(stockId, period);
        long size = redisTemplate.opsForList().size(key) - 1;
        List<String> minKList;
        if (size < end){
            minKList = redisTemplate.opsForList().range(key,start,size);
        }else {
            minKList = redisTemplate.opsForList().range(key,start,end);
        }
        if (!ObjectUtils.isEmpty(minKList)){
            for (String str : minKList){
                KEntity kEntity = new KEntity();
                kEntity = kEntity.parseFromRedis(str);
                entityList.add(kEntity);
            }
        }
        return entityList;
    }
}
