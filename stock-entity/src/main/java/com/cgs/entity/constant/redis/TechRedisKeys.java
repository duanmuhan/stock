package com.cgs.entity.constant.redis;

public class TechRedisKeys {

  private static final String TECH_PREFIX = "stock:tech:";
  private static final String EMA_PREFIX = TECH_PREFIX + "ema:";
  private static final String KDJ_PREFIX = TECH_PREFIX + "kdj:";
  private static final String MACD_PREFIX = TECH_PREFIX + "macd:";
  private static final String RSI_PREFIX = TECH_PREFIX + "rsi:";

  public static String emaKeys(String stockId){
    return EMA_PREFIX + stockId;
  }

  public static String kdjKeys(String stockId){
    return KDJ_PREFIX + stockId;
  }

  public static String macdKeys(String stockId){
    return MACD_PREFIX + stockId;
  }

  public static String rsiKeys(String stockId){
    return RSI_PREFIX + stockId;
  }

}
