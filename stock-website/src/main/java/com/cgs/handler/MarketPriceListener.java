package com.cgs.handler;


import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MarketPriceListener implements MessageListener {

  @Override
  public void onMessage(Message message) {

  }
}
