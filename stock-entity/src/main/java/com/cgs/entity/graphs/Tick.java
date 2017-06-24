package com.cgs.entity.graphs;

import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/10.
 */
public class Tick implements RedisSerializer<Tick,String>,AMQPSerializer<Tick> {

  private static final String FIELD_SEPERATOR = ",";

  private String stockId;
  private double price;
  private long volume;
  private long timestamp;

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toRedisValue() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getStockId()).append(FIELD_SEPERATOR);
    sb.append(this.getPrice()).append(FIELD_SEPERATOR);
    sb.append(this.getVolume()).append(FIELD_SEPERATOR);
    sb.append(this.getTimestamp()).append(FIELD_SEPERATOR);
    return sb.toString();
  }

  @Override
  public Tick parseFromRedis(String string) {
    String[] array = string.split(FIELD_SEPERATOR);
    Tick tick = new Tick();
    tick.setStockId(array[0]);
    tick.setPrice(Double.valueOf(array[1]));
    tick.setVolume(Long.valueOf(array[2]));
    tick.setTimestamp(Long.valueOf(array[3]));
    return tick;
  }

  @Override
  public String toMessage() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getStockId()).append(FIELD_SEPERATOR);
    sb.append(this.getPrice()).append(FIELD_SEPERATOR);
    sb.append(this.getVolume()).append(FIELD_SEPERATOR);
    sb.append(this.getTimestamp()).append(FIELD_SEPERATOR);
    return sb.toString();
  }

  @Override
  public Tick parseFromMessage(String string) {
    String[] array = string.split(FIELD_SEPERATOR);
    Tick tick = new Tick();
    tick.setStockId(array[0]);
    tick.setPrice(Double.valueOf(array[1]));
    tick.setVolume(Long.valueOf(array[2]));
    tick.setTimestamp(Long.valueOf(array[3]));
    return tick;
  }
}
