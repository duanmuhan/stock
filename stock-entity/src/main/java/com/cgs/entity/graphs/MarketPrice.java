package com.cgs.entity.graphs;

import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/10.
 */
public class MarketPrice implements RedisSerializer<MarketPrice,String>,AMQPSerializer<String> {

  private static final String FIELD_SEPERATOR = ",";

  private int stockId;
  private double open;
  private double close;
  private double high;
  private double low;
  private long vol;
  private double volume;
  private long timestamp;

  public int getStockId() {
    return stockId;
  }

  public void setStockId(int stockId) {
    this.stockId = stockId;
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

  public long getVol() {
    return vol;
  }

  public void setVol(long vol) {
    this.vol = vol;
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String toRedisValue(){
    StringBuilder sb = new StringBuilder();
    sb.append(this.getStockId()).append(FIELD_SEPERATOR);
    sb.append(this.getOpen()).append(FIELD_SEPERATOR);
    sb.append(this.getClose()).append(FIELD_SEPERATOR);
    sb.append(this.getHigh()).append(FIELD_SEPERATOR);
    sb.append(this.getLow()).append(FIELD_SEPERATOR);
    sb.append(this.getVol()).append(FIELD_SEPERATOR);
    sb.append(this.getVolume()).append(FIELD_SEPERATOR);
    sb.append(this.getTimestamp()).append(FIELD_SEPERATOR);
    return sb.toString();
  }

  @Override
  public MarketPrice parseFromRedis(String string) {
    return null;
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
