package com.cgs.handler;

import com.cgs.entity.graphs.Tick;
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
public class TickHandler implements MessageListener {

    @Autowired
    private QuotesHandler quotesHandler;

    @Override
    public void onMessage(javax.jms.Message message) {
        Map<String, WebSocketSessionEntity> sessionMap = quotesHandler.getSessionMap();
        try {
            QuotesMessage.TickResponse response = parseTick((TextMessage) message);
            WebSocketMessage webSocketMessage = new BinaryMessage(response.toByteArray());
            for (String key : sessionMap.keySet()) {
                sessionMap.get(key).send(webSocketMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private QuotesMessage.TickResponse parseTick(TextMessage textMessage) throws JMSException {
        QuotesMessage.TickResponse.Builder builder = QuotesMessage.TickResponse.newBuilder();
        String message = textMessage.getText();
        Tick tick = new Tick();
        tick = tick.parseFromMessage(message);
        QuotesMessage.TickItem.Builder itemBuilder = QuotesMessage.TickItem.newBuilder();

        itemBuilder.setPrice(tick.getPrice());
        itemBuilder.setVolume(tick.getVolume());
        itemBuilder.setTimestamp(tick.getTimestamp());

        builder.setStockId(tick.getStockId());
        builder.setServerTime(tick.getTimestamp());
        builder.addItems(itemBuilder.build());
        return builder.build();
    }
}
