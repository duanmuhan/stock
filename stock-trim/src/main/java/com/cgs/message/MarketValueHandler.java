package com.cgs.message;

import com.cgs.amqp.AMQPClient;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.service.graphs.KService;
import com.cgs.service.graphs.MarketValueService;
import com.cgs.service.graphs.TickService;
import com.cgs.service.graphs.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MarketValueHandler implements MessageListener {

  @Autowired
  private KService kService;
  @Autowired
  private MarketValueService marketValueService;
  @Autowired
  private TickService tickService;
  @Autowired
  private TrendService trendService;
  @Autowired
  private AMQPClient amqpClient;

  @Override
  public void onMessage(Message message) {
    MarketPrice marketPrice = parseMarketValueToMarketPrice(message);
    marketValueService.handle(marketPrice);
    kService.handle(marketPrice);
    tickService.handle(marketPrice);
    trendService.handle(marketPrice);
  }

  private MarketPrice parseMarketValueToMarketPrice(Message message){
    MarketPrice marketPrice = new MarketPrice();
//    try {
//      //MarketValue marketValue = JSONObject.parseObject(message.getJMSType());
//    } catch (JMSException e) {
//      e.printStackTrace();
//    }
    return marketPrice;
  }
}
