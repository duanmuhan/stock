package com.cgs.dao;

import com.cgs.entity.constant.redis.SpiderKeys;
import com.cgs.entity.model.spider.CompanyBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  public Map<String,List<CompanyBase>> findCompanyMap(){
    Map<String,List<CompanyBase>> companyMap = new HashMap<>();
    Set<String> keySet = redisTemplate.keys(SpiderKeys.redisCompanyPrefix + "*");
    for (String key : keySet){
      long size = redisTemplate.opsForList().size(key);
      List<String> list = redisTemplate.opsForList().range(key,0,size);
      List<CompanyBase> companyBaseList = new ArrayList<>();
      for (String company : list){
        CompanyBase companyBase = new CompanyBase();
        companyBaseList.add(companyBase.parseFromRedis(company));
      }
      companyMap.put(key,companyBaseList);
    }
    return companyMap;
  }
}
