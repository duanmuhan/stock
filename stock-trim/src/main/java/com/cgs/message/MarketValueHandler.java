package com.cgs.message;

import com.alibaba.fastjson.JSON;
import com.cgs.cache.MarketValueCache;
import com.cgs.entity.graphs.MarketPrice;
import com.cgs.entity.model.spider.MarketValue;
import com.cgs.service.graphs.KService;
import com.cgs.service.graphs.MarketValueService;
import com.cgs.service.graphs.TickService;
import com.cgs.service.graphs.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

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
  MarketValueCache marketValueCache;

  @Override
  public void onMessage(Message message) {
    try {
      MarketPrice marketPrice = parseMarketValueToMarketPrice((TextMessage)message);
      if (marketValueCache.exists(marketPrice) && marketValueCache.get(marketPrice).equals(marketPrice.toRedisValue())){
        return;
      }
      marketValueService.handle(marketPrice);
      kService.handle(marketPrice);
      tickService.handle(marketPrice);
      trendService.handle(marketPrice);
    } catch (JMSException e) {
      e.printStackTrace();
    }

  }

  private MarketPrice parseMarketValueToMarketPrice(TextMessage message) throws JMSException {
    MarketPrice marketPrice = new MarketPrice();
    MarketValue marketValue = JSON.parseObject(message.getText(),MarketValue.class);
    marketPrice.setStockId(marketValue.getStockId());
    marketPrice.setPrice(marketValue.getCurrent());
    marketPrice.setHigh(marketValue.getHighest());
    marketPrice.setLow(marketValue.getLowest());
    marketPrice.setOpen(marketValue.getOpen());
    marketPrice.setClose(marketValue.getPreClose());
    marketPrice.setTimestamp(marketValue.getTimestamp());
    marketPrice.setVol(marketValue.getSettlementAmount());
    marketPrice.setVolume(marketValue.getSettlement());
    return marketPrice;
  }
}
