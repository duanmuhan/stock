package com.cgs.entity.graphs;

/**
 * Created by Administrator on 2017/6/10.
 */
public class MarketPrice {

  private int stockId;
  private long newvol;
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

  public long getNewvol() {
    return newvol;
  }

  public void setNewvol(long newvol) {
    this.newvol = newvol;
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
}
