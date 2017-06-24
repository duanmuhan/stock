package com.cgs.entity.graphs;

import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/10.
 */
public class MarketPrice implements RedisSerializer<MarketPrice,String>,AMQPSerializer<MarketPrice> {

  private static final String FIELD_SEPERATOR = ",";

  private String stockId;
  private double open;
  private double close;
  private double high;
  private double low;
  private double price;
  private long vol;
  private double volume;
  private long timestamp;

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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
    sb.append(this.getTimestamp());
    return sb.toString();
  }

  @Override
  public MarketPrice parseFromRedis(String string) {
    String[] array = string.split(FIELD_SEPERATOR);
    if (array.length != 9){
      return null;
    }
    MarketPrice marketPrice = new MarketPrice();
    marketPrice.setStockId(array[0]);
    marketPrice.setOpen(Double.valueOf(array[1]));
    marketPrice.setClose(Double.valueOf(array[2]));
    marketPrice.setHigh(Double.valueOf(array[3]));
    marketPrice.setLow(Double.valueOf(array[4]));
    marketPrice.setPrice(Double.valueOf(array[5]));
    marketPrice.setVol(Long.valueOf(array[6]));
    marketPrice.setVolume(Double.valueOf(array[7]));
    marketPrice.setTimestamp(Long.valueOf(array[8]));
    return marketPrice;
}

  @Override
  public String toMessage() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getStockId()).append(FIELD_SEPERATOR);
    sb.append(this.getOpen()).append(FIELD_SEPERATOR);
    sb.append(this.getClose()).append(FIELD_SEPERATOR);
    sb.append(this.getHigh()).append(FIELD_SEPERATOR);
    sb.append(this.getLow()).append(FIELD_SEPERATOR);
    sb.append(this.getVol()).append(FIELD_SEPERATOR);
    sb.append(this.getVolume()).append(FIELD_SEPERATOR);
    sb.append(this.getTimestamp());
    return sb.toString();
  }

  @Override
  public MarketPrice parseFromMessage(String string) {
    String[] array = string.split(FIELD_SEPERATOR);
    if (array.length != 9){
      return null;
    }
    MarketPrice marketPrice = new MarketPrice();
    marketPrice.setStockId(array[0]);
    marketPrice.setOpen(Double.valueOf(array[1]));
    marketPrice.setClose(Double.valueOf(array[2]));
    marketPrice.setHigh(Double.valueOf(array[3]));
    marketPrice.setLow(Double.valueOf(array[4]));
    marketPrice.setPrice(Double.valueOf(array[5]));
    marketPrice.setVol(Long.valueOf(array[6]));
    marketPrice.setVolume(Double.valueOf(array[7]));
    marketPrice.setTimestamp(Long.valueOf(array[8]));
    return marketPrice;
  }
}
