package com.cgs.handler;

import com.cgs.entity.graphs.MarketPrice;
import com.cgs.quotes.message.QuotesMessage;
import com.cgs.websocket.QuotesHandler;
import com.cgs.websocket.entity.WebSocketSessionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class MarketPriceListener implements MessageListener {

  private static Logger logger = LoggerFactory.getLogger(MarketPriceListener.class);

  @Autowired
  private QuotesHandler quotesHandler;

  @Override
  public void onMessage(Message message) {
    try {
      Map<String,WebSocketSessionEntity> sessionMap = quotesHandler.getSessionMap();
      TextMessage textMessage = (TextMessage)message;
      logger.info(textMessage.getText());
      QuotesMessage.MarketPriceResponse response = parseMarketPrice(textMessage);
      WebSocketMessage webSocketMessage = new BinaryMessage(response.toByteArray());
      for (String key : sessionMap.keySet()){
        sessionMap.get(key).send(webSocketMessage);
      }
    } catch (Exception e) {
      logger.error("exception at MarketPriceListener :{}",e.getMessage());
    }
  }

  private QuotesMessage.MarketPriceResponse parseMarketPrice(TextMessage message) throws JMSException {
    QuotesMessage.MarketPriceResponse.Builder builder = QuotesMessage.MarketPriceResponse.newBuilder();
    MarketPrice marketPrice = new MarketPrice();
    String text = message.getText();
    marketPrice = marketPrice.parseFromMessage(text);
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
