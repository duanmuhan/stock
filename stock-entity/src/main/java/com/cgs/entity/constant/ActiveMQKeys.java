package com.cgs.entity.constant;

public enum ActiveMQKeys {

  MARKET_VALUE("marketValue"),
  K("k");

  private String context;

  ActiveMQKeys(String context) {
    this.context = context;
  }

  public String getContext() {
    return context;
  }
}
