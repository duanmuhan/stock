package com.cgs.service;

import com.cgs.dao.KLineDao;
import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.graphs.KEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */
@Service
public class KQueryService {

    @Autowired
    private KLineDao kLineDao;

    public List<KEntity> getKEntityList(String stockId, KPeriod period,long start, long end){
        List<KEntity> entityList = new ArrayList<>();
        switch (period){
            case MIN:
                entityList = kLineDao.findMinKListById(stockId,start,end);
                break;
            case FIVE_MIN:
                entityList = kLineDao.find5MinKListById(stockId,start,end);
                break;
            case FIFTEEN_MIN:
                entityList = kLineDao.find15MinKListById(stockId,start,end);
                break;
            case HALF_HOUR:
                entityList = kLineDao.find30MinKListById(stockId,start,end);
                break;
            case HOUR:
                entityList = kLineDao.findHourKListById(stockId,start,end);
                break;
        }
        return entityList;
    }
}
