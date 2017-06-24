package com.cgs.entity.graphs;

import com.cgs.entity.constant.TrendPeriod;
import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/10.
 */
public class TrendMin implements RedisSerializer<TrendMin,String>,AMQPSerializer<TrendMin> {

  private final String FIELD_SEPERATOR = ",";

  private String stockId;
  private TrendPeriod trendPeriod;
  private double close;
  private double vwap;
  private long volume;
  private long time;

  public TrendPeriod getTrendPeriod() {
    return trendPeriod;
  }

  public void setTrendPeriod(TrendPeriod trendPeriod) {
    this.trendPeriod = trendPeriod;
  }

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public double getClose() {
    return close;
  }

  public void setClose(double close) {
    this.close = close;
  }

  public double getVwap() {
    return vwap;
  }

  public void setVwap(double vwap) {
    this.vwap = vwap;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  @Override
  public String toRedisValue() {
    String redisString = this.getStockId() + FIELD_SEPERATOR + this.getTrendPeriod().name() + FIELD_SEPERATOR + this.getClose() + FIELD_SEPERATOR
            + this.getVwap() + FIELD_SEPERATOR + this.getVolume() + FIELD_SEPERATOR + this.getTime();
    return redisString;
  }

  @Override
  public TrendMin parseFromRedis(String string) {
    String[] array = string.split(FIELD_SEPERATOR);
    if (array.length != 6){
      return null;
    }
    TrendMin trendMin = new TrendMin();
    trendMin.setStockId(array[0]);
    trendMin.setTrendPeriod(TrendPeriod.valueOf(array[1]));
    trendMin.setClose(Double.valueOf(array[2]));
    trendMin.setVwap(Double.valueOf(array[3]));
    trendMin.setVolume(Long.valueOf(array[4]));
    trendMin.setTime(Long.valueOf(array[5]));
    return trendMin;
  }

  @Override
  public String toMessage() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getStockId()).append(FIELD_SEPERATOR);
    sb.append(this.getTrendPeriod().name()).append(FIELD_SEPERATOR);
    sb.append(this.getClose()).append(FIELD_SEPERATOR);
    sb.append(this.getVwap()).append(FIELD_SEPERATOR);
    sb.append(this.getVolume()).append(FIELD_SEPERATOR);
    sb.append(this.getTime());
    return sb.toString();
  }

  @Override
  public TrendMin parseFromMessage(String string) {
    String[] array = string.split(FIELD_SEPERATOR);
    if (array.length != 6){
      return null;
    }
    TrendMin trendMin = new TrendMin();
    trendMin.setStockId(array[0]);
    trendMin.setTrendPeriod(TrendPeriod.valueOf(array[1]));
    trendMin.setClose(Double.valueOf(array[2]));
    trendMin.setVwap(Double.valueOf(array[3]));
    trendMin.setVolume(Long.valueOf(array[4]));
    trendMin.setTime(Long.valueOf(array[5]));
    return trendMin;
  }
}
