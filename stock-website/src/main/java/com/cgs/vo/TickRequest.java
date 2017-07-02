package com.cgs.vo;

/**
 * Created by Administrator on 2017/7/3.
 */
public class TickRequest {

    private String stockId;
    private long begin;
    private long end;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public long getBegin() {
        return begin;
    }

    public void setBegin(long begin) {
        this.begin = begin;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
