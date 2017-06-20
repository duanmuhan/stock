package com.cgs.entity.graphs;

import com.cgs.entity.model.AMQPSerializer;
import com.cgs.entity.model.RedisSerializer;

/**
 * Created by Administrator on 2017/6/10.
 */
public class Tick implements RedisSerializer<KEntity,String>,AMQPSerializer<String> {

  private static final String FIELD_SEPERATOR = ",";

  private int stockId;
  private double price;
  private long volume;
  private long timestamp;

  public int getStockId() {
    return stockId;
  }

  public void setStockId(int stockId) {
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
    return null;
  }

  @Override
  public KEntity parseFromRedis(String string) {
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
