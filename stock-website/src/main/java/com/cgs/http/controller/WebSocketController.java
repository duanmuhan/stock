package com.cgs.http.controller;

import com.cgs.constant.API;
import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.Tick;
import com.cgs.entity.graphs.TrendMin;
import com.cgs.vo.KRequest;
import com.cgs.vo.TickRequest;
import com.cgs.vo.TrendRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */
@Controller
public class WebSocketController {

    @MessageMapping(API.K)
    @ResponseBody
    public List<KEntity> kData(KRequest kRequest){
        List<KEntity> entityList = new ArrayList<>();
        return entityList;
    }

    @MessageMapping(API.TREND_MIN)
    @ResponseBody
    public List<TrendMin> trendMin(TrendRequest trendRequest){
        List<TrendMin> trendMinList = new ArrayList<>();
        return trendMinList;
    }

    @MessageMapping(API.TREND_5MIN)
    @ResponseBody
    public List<TrendMin> trend5Min(TrendRequest trendRequest){
        List<TrendMin> trendMinList = new ArrayList<>();
        return trendMinList;
    }

    @MessageMapping(API.TICK)
    @ResponseBody
    public List<Tick> tick(TickRequest tickRequest){
        List<Tick> tickList = new ArrayList<>();
        return tickList;
    }
}
