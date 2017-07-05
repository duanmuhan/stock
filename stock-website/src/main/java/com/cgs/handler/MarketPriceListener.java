package com.cgs.handler;

import com.alibaba.fastjson.JSON;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.quotes.message.QuotesMessage;
import com.cgs.websocket.QuotesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class MarketPriceListener implements MessageListener {

  @Autowired
  private QuotesHandler quotesHandler;

  @Override
  public void onMessage(Message message) {
    Map<String,WebSocketSession> sessionMap = quotesHandler.getSessionMap();

  }

  private QuotesMessage.MarketPriceResponse parseMarketPrice(TextMessage message) throws JMSException {
    QuotesMessage.MarketPriceResponse.Builder builder = QuotesMessage.MarketPriceResponse.newBuilder();
    MarketPrice marketPrice = JSON.parseObject(message.getText(),MarketPrice.class);
    builder.setServerTime(marketPrice.getTimestamp());
    QuotesMessage.MarketPriceItem.Builder itemBuilder = QuotesMessage.MarketPriceItem.newBuilder();
    itemBuilder.setStockId(marketPrice.getStockId());
    itemBuilder.setClose(marketPrice.getClose());
    itemBuilder.setHigh(marketPrice.getHigh());
    itemBuilder.setLow(marketPrice.getLow());
    itemBuilder.setOpen(marketPrice.getOpen());
    itemBuilder.setPrice(marketPrice.getPrice());
    itemBuilder.setVol(marketPrice.getVol());
    itemBuilder.setVolume(marketPrice.getVolume());
    itemBuilder.setTimestamp(marketPrice.getTimestamp());
    builder.addItems(itemBuilder.build());
    return builder.build();
  }
}
