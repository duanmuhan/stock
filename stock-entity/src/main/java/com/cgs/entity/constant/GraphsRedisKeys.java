package com.cgs.entity.constant;

import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.MarketValue;
import com.cgs.entity.graphs.Tick;
import com.cgs.entity.graphs.TrendMin;

public class GraphsRedisKeys {

  private static final String GRAPHS_PREFIX = "stock:graphs:";
  private static final String K_PREFIX = GRAPHS_PREFIX + "k:";
  private static final String TREND_PREFIX = GRAPHS_PREFIX + "trend:";
  private static final String TICK_PREFIX = GRAPHS_PREFIX + "tick:";
  private static final String MARKET_PREFIX = GRAPHS_PREFIX + "marketprice:";

  public String kDataKey(KEntity kEntity){
    return K_PREFIX + kEntity.getPeriod().name() + ":" + kEntity.getStockId();
  }

  public String trendKey(TrendMin trendMin){
    return TREND_PREFIX + trendMin.getTrendPeriod().name() + ":" + trendMin.getStockId();
  }

  //TODO 这个地方需要确认实体类型
  public String marketValueKey(MarketValue marketValue){
    return MARKET_PREFIX;
  }

  public String tickKey(Tick tick){
    return TICK_PREFIX + tick.getStockId();
  }
}
