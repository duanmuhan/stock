package com.cgs.cache;

import com.cgs.entity.graphs.MarketValue;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MarketValueCache {

  private Map<Integer,MarketValue> marketValueCache = new HashMap<>();
}
