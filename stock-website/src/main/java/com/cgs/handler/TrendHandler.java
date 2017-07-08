package com.cgs.handler;

import com.cgs.entity.graphs.TrendMin;
import com.cgs.quotes.message.QuotesMessage;
import com.cgs.websocket.QuotesHandler;
import com.cgs.websocket.entity.WebSocketSessionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketMessage;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class TrendHandler implements MessageListener {

    @Autowired
    private QuotesHandler quotesHandler;

    @Override
    public void onMessage(javax.jms.Message message) {
        Map<String, WebSocketSessionEntity> sessionMap = quotesHandler.getSessionMap();
        try {
            QuotesMessage.TrendResponse response = parseTrend((TextMessage) message);
            WebSocketMessage webSocketMessage = new BinaryMessage(response.toByteArray());
            for (String key : sessionMap.keySet()) {
                sessionMap.get(key).send(webSocketMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private QuotesMessage.TrendResponse parseTrend(TextMessage message) throws JMSException {
        QuotesMessage.TrendResponse.Builder builder = QuotesMessage.TrendResponse.newBuilder();
        String text = message.getText();
        TrendMin trendMin = new TrendMin();
        trendMin = trendMin.parseFromMessage(text);
        QuotesMessage.TrendItem.Builder itemBuilder = QuotesMessage.TrendItem.newBuilder();
        itemBuilder.setClose(trendMin.getClose());
        itemBuilder.setTime(trendMin.getTime());
        itemBuilder.setVolume(trendMin.getVolume());
        itemBuilder.setVwap(trendMin.getVwap());

        builder.setStockId(trendMin.getStockId());
        builder.setPeriodValue(trendMin.getTrendPeriod().ordinal());
        builder.addItems(itemBuilder.build());
        return builder.build();
    }

}
