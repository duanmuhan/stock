package com.cgs.handler;

import com.cgs.websocket.QuotesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

public class KDataListener implements MessageListener {

    @Autowired
    private QuotesHandler quotesHandler;

    @Override
    public void onMessage(Message message) {
        Map<String,WebSocketSession> sessionMap = quotesHandler.getSessionMap();
        try {
            for (String key : sessionMap.keySet()){
                WebSocketMessage webSocketMessage = new TextMessage(message.toString());
                sessionMap.get(key).sendMessage(webSocketMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
