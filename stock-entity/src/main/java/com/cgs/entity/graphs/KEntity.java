package com.cgs.entity.graphs;

import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/8.
 */
public class KEntity implements RedisSerializer<KEntity,String>,AMQPSerializer<KEntity> {

    private static final String FIELD_SEPERATOR = ",";

    private KPeriod period;
    private String stockId;
    private double high;
    private double low;
    private double open;
    private double close;
    private long volume;
    private long timestamp;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
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

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public String toRedisValue(){
        return this.getStockId() + FIELD_SEPERATOR + this.getPeriod().name() + FIELD_SEPERATOR + this.getHigh() + FIELD_SEPERATOR + this.getLow() + FIELD_SEPERATOR
            + this.getOpen() + FIELD_SEPERATOR + this.getClose() + FIELD_SEPERATOR + this.getVolume() + FIELD_SEPERATOR + this.getTimestamp();
    }

    public KEntity parseFromRedis(String value){
        KEntity entity = new KEntity();
        String[] array = value.split(FIELD_SEPERATOR);
        if (array.length != 8){
            return null;
        }
        entity.setStockId(array[0]);
        entity.setPeriod(KPeriod.valueOf(array[1]));
        entity.setHigh(Double.valueOf(array[2]));
        entity.setLow(Double.valueOf(array[3]));
        entity.setOpen(Double.valueOf(array[4]));
        entity.setClose(Double.valueOf(array[5]));
        entity.setVolume(Long.valueOf(array[6]));
        entity.setTimestamp(Long.valueOf(array[7]));
        return entity;
    }

    @Override
    public String toMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getStockId()).append(FIELD_SEPERATOR);
        sb.append(this.getPeriod()).append(FIELD_SEPERATOR);
        sb.append(this.getHigh()).append(FIELD_SEPERATOR);
        sb.append(this.getLow()).append(FIELD_SEPERATOR);
        sb.append(this.getOpen()).append(FIELD_SEPERATOR);
        sb.append(this.getClose()).append(FIELD_SEPERATOR);
        sb.append(this.getVolume()).append(FIELD_SEPERATOR);
        sb.append(this.getTimestamp());
        return sb.toString();
    }

    @Override
    public KEntity parseFromMessage(String string) {
        KEntity entity = new KEntity();
        String[] array = string.split(FIELD_SEPERATOR);
        if (array.length != 8){
            return null;
        }
        entity.setStockId(array[0]);
        entity.setPeriod(KPeriod.valueOf(array[1]));
        entity.setHigh(Double.valueOf(array[2]));
        entity.setLow(Double.valueOf(array[3]));
        entity.setOpen(Double.valueOf(array[4]));
        entity.setClose(Double.valueOf(array[5]));
        entity.setVolume(Long.valueOf(array[6]));
        entity.setTimestamp(Long.valueOf(array[7]));
        return entity;
    }
}
