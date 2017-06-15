package com.cgs.entity.graphs;

import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/8.
 */
public class KEntity implements RedisSerializer<KEntity,String>,AMQPSerializer<String> {

    private static final String FIELD_SEPERATOR = ",";

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

    public String toRedisValue(){
        return this.getStockId() + FIELD_SEPERATOR + this.getHigh() + FIELD_SEPERATOR + this.getLow() + FIELD_SEPERATOR
            + this.getOpen() + FIELD_SEPERATOR + this.getClose() + FIELD_SEPERATOR + this.getTimestamp();
    }

    public KEntity parseFromRedis(String value){
        KEntity entity = new KEntity();
        return entity;
    }

    @Override
    public String toMessage() {
        return null;
    }

    @Override
    public String parseFromMessage(String string) {
        return null;
    }
}
