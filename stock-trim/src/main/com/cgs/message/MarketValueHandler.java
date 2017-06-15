package com.cgs.message;

import com.cgs.service.graphs.KService;
import com.cgs.service.graphs.MarketValueService;
import com.cgs.service.graphs.TickService;
import com.cgs.service.graphs.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class MarketValueHandler implements MessageHandler {

  @Autowired
  KService kService;
  @Autowired
  MarketValueService marketValueService;
  @Autowired
  TickService tickService;
  @Autowired
  TrendService trendService;

  @Override
  public void handleMessage(Message<?> message) throws MessagingException {

  }
}
