package com.cgs.entity.constant;

public enum TrendPeriod {

  MIN("trendMin"),
  FIVE_MIN("trend5min");

  private String value;

  TrendPeriod(String value){
    this.value = value;
  }

  public String getValue(){
    return this.value;
  }

  public TrendPeriod parseFromInteger(int value){
    switch (value){
      case 0:
        return MIN;
      case 1:
        return FIVE_MIN;
      default:
        throw new IllegalArgumentException();
    }
  }
}
