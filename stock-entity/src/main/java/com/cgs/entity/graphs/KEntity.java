package com.cgs.entity.graphs;

import com.cgs.entity.constant.KPeriod;

/**
 * Created by Administrator on 2017/6/8.
 */
public class KEntity {

    private KPeriod period;
    private int stockId;
    private double high;
    private double low;
    private double open;
    private double close;
    private long timestamp;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public KPeriod getPeriod() {
        return period;
    }

    public void setPeriod(KPeriod period) {
        this.period = period;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
