package com.cgs.vo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
public class MarketPriceRequest {

    private List<String> stockIds;

    public List<String> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<String> stockIds) {
        this.stockIds = stockIds;
    }
}
