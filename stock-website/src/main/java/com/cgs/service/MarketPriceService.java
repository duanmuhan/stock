package com.cgs.service;

import com.cgs.dao.MarketPriceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class MarketPriceService {

    @Autowired
    private MarketPriceDao marketPriceDao;
}
