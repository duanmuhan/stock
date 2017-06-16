package com.cgs.message;

import com.cgs.entity.graphs.MarketValue;
import com.cgs.service.graphs.KService;
import com.cgs.service.graphs.MarketValueService;
import com.cgs.service.graphs.TickService;
import com.cgs.service.graphs.TrendService;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarketValueHandler implements MessageListener {

  @Autowired
  KService kService;
  @Autowired
  MarketValueService marketValueService;
  @Autowired
  TickService tickService;
  @Autowired
  TrendService trendService;


  @Override
  public void onMessage(Message message) {
    MarketValue marketValue = new MarketValue();
    kService.handle(marketValue);
    marketValueService.handle(marketValue);
    tickService.handle(marketValue);
    trendService.handle(marketValue);
  }
}
