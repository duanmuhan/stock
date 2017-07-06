package com.cgs.service;

import com.cgs.dao.TrendMinDao;
import com.cgs.entity.constant.TrendPeriod;
import com.cgs.entity.graphs.TrendMin;
import com.cgs.vo.TrendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class TrendService {

    @Autowired
    private TrendMinDao trendMinDao;

    public List<TrendMin> findTrendById(TrendRequest trendRequest){
        List<TrendMin> trendMinList = new ArrayList<>();
        if (TrendPeriod.valueOf(trendRequest.getTrendPeriod()) == TrendPeriod.MIN){
            trendMinList = trendMinDao.findMinTrendById(trendRequest.getStockId(),trendRequest.getStart(),trendRequest.getEnd());
        }else if (TrendPeriod.valueOf(trendRequest.getTrendPeriod()) == TrendPeriod.FIVE_MIN){
            trendMinList = trendMinDao.find5MinTrendById(trendRequest.getStockId(),trendRequest.getStart(),trendRequest.getEnd());
        }
        return trendMinList;
    }
}
