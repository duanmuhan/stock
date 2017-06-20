package com.cgs.entity.constant;

public enum TrendPeriod {

  MIN("min"),
  FIVE_MIN("5min");

  private String value;

  TrendPeriod(String value){
    this.value = value;
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