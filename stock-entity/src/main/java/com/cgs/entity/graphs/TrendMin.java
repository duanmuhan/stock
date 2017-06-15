package com.cgs.entity.graphs;

import com.cgs.entity.constant.TrendPeriod;

/**
 * Created by Administrator on 2017/6/10.
 */
public class TrendMin {

  private TrendPeriod trendPeriod;
  private int stockId;
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

  public int getStockId() {
    return stockId;
  }

  public void setStockId(int stockId) {
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
}
