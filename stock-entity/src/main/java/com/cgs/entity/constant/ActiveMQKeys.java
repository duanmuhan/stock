package com.cgs.entity.constant;

public enum ActiveMQKeys {

  MARKET_VALUE("marketValue"),
  TREND("trendMin"),
  TICK("tick"),
  KMIN("kMin"),
  KFIVEMIN("kFiveMin"),
  KFIFTEENMIN("kFifteenMin"),
  KHALFHOUR("kHalfHour"),
  KHOUR("kHour"),
  KDAY("kDay"),
  KMONTH("kMonth"),
  KYEAR("kYear");

  private String context;

  ActiveMQKeys(String context) {
    this.context = context;
  }

  public String getContext() {
    return context;
  }
}
