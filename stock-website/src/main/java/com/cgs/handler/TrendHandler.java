package com.cgs.handler;

import com.cgs.websocket.QuotesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.MessageListener;

@Component
public class TrendHandler implements MessageListener {

  @Autowired
  private QuotesHandler quotesHandler;

  @Override
  public void onMessage(javax.jms.Message message) {

  }
}
