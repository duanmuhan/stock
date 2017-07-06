package com.cgs.entity.constant.redis;

import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.entity.graphs.Tick;
import com.cgs.entity.graphs.TrendMin;

public class GraphsRedisKeys {

  private static final String GRAPHS_PREFIX = "stock:graphs:";
  private static final String K_PREFIX = GRAPHS_PREFIX + "k:";
  private static final String TREND_PREFIX = GRAPHS_PREFIX + "trend:";
  private static final String TICK_PREFIX = GRAPHS_PREFIX + "tick:";
  private static final String MARKET_PREFIX = GRAPHS_PREFIX + "marketprice:";

  public static String kDataKey(KEntity kEntity){
    return K_PREFIX + kEntity.getPeriod().getValue() + ":" + kEntity.getStockId();
  }

  public static String kDataKey(String stockId,String period){
    return K_PREFIX + period + ":" + stockId;
  }

  public static String trendKey(TrendMin trendMin){
    return TREND_PREFIX + trendMin.getTrendPeriod().getValue() + ":" + trendMin.getStockId();
  }

  public static String trendKey(String stockId,String period){
    return TREND_PREFIX + period + ":" + stockId;
  }

  public static String marketValueKey(MarketPrice marketPrice){
    return MARKET_PREFIX + marketPrice.getStockId();
  }

  public static String marketValueKey(String stockId){
    return MARKET_PREFIX + stockId;
  }

  public static String tickKey(Tick tick){
    return TICK_PREFIX + tick.getStockId();
  }

  public static String tickKey(String stockId){
    return TICK_PREFIX + stockId;
  }

}
