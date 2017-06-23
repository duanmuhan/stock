package com.cgs.service.graphs;

import com.cgs.cache.KCache;
import com.cgs.dao.KDao;
import com.cgs.entity.graphs.KEntity;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.service.graphs.interfaces.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KService implements IHandler{

  @Autowired
  KCache kCache;
  @Autowired
  KDao kDao;

  public void handle(MarketPrice marketPrice) {
    KEntity kEntity = parseK(marketPrice);
    kDao.add(kEntity);
  }

  private KEntity parseK(MarketPrice marketPrice){
    KEntity kEntity = new KEntity();
    return kEntity;
  }
}
