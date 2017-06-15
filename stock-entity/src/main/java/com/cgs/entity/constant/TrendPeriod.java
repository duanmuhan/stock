package com.cgs.entity.constant;

public enum TrendPeriod {

  MIN("min"),
  FIVEMIN("5min");

  private String value;

  TrendPeriod(String value){
    this.value = value;
  }
}
