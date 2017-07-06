package com.cgs.vo;

/**
 * Created by Administrator on 2017/7/3.
 */
public class TrendRequest {

    private String stockId;
    private String trendPeriod;
    private long start;
    private long end;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getTrendPeriod() {
        return trendPeriod;
    }

    public void setTrendPeriod(String trendPeriod) {
        this.trendPeriod = trendPeriod;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
