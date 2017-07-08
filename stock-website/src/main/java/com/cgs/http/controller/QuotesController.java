package com.cgs.http.controller;

import com.cgs.constant.API;
import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.Tick;
import com.cgs.entity.graphs.TrendMin;
import com.cgs.service.KQueryService;
import com.cgs.service.MarketPriceService;
import com.cgs.service.TickService;
import com.cgs.service.TrendService;
import com.cgs.utils.MessageGenerator;
import com.cgs.vo.KRequest;
import com.cgs.vo.MarketPriceRequest;
import com.cgs.vo.TickRequest;
import com.cgs.vo.TrendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
@Controller
public class QuotesController {

    @Autowired
    private KQueryService kQueryService;
    @Autowired
    private MarketPriceService marketPriceService;
    @Autowired
    private TickService tickService;
    @Autowired
    private TrendService trendService;
    @Autowired
    private MessageGenerator messageGenerator;

    @RequestMapping(value = API.K, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object k(HttpServletResponse response, @RequestBody KRequest request) {
        List<KEntity> entityList = kQueryService.getKEntityList(request.getStockId(), KPeriod.valueOf(request.getPeriod()), request.getStart(), request.getEnd());
        response.setStatus(HttpServletResponse.SC_CREATED);
        return messageGenerator.create(MessageGenerator.MessageCode.COMMON_SUCCESS, entityList);
    }

    @RequestMapping(value = API.MARKET_PRICE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object marketPrice(HttpServletResponse response, @RequestBody MarketPriceRequest marketPriceRequest) {
        List<String> stockIds = marketPriceRequest.getStockIds();
        response.setStatus(HttpServletResponse.SC_CREATED);
        return messageGenerator.create(MessageGenerator.MessageCode.COMMON_SUCCESS,stockIds);
    }

    @RequestMapping(value = API.TICK,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object tick(HttpServletResponse response, @RequestBody TickRequest tickRequest){
        List<Tick> tickList = tickService.findTickById(tickRequest);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return messageGenerator.create(MessageGenerator.MessageCode.COMMON_SUCCESS,tickList);
    }

    @RequestMapping(value = API.TREND_MIN,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object trend(HttpServletResponse response, @RequestBody TrendRequest trendRequest){
        List<TrendMin> minList = trendService.findTrendById(trendRequest);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return messageGenerator.create(MessageGenerator.MessageCode.COMMON_SUCCESS,minList);
    }
}
