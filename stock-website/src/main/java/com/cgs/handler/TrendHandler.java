package com.cgs.handler;

import org.springframework.stereotype.Component;

import javax.jms.MessageListener;

@Component
public class TrendHandler implements MessageListener {

  @Override
  public void onMessage(javax.jms.Message message) {

  }
}
