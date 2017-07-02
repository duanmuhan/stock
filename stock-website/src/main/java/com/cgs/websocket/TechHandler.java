package com.cgs.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequestMapping("/techHandler")
public class TechHandler extends TextWebSocketHandler {

    private Map<String,WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if (session.isOpen()){
            System.out.println("fuckyou");
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.put(session.getId(),session);
        System.out.println("fuckyou established" + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("closed");
    }

    public Map<String,WebSocketSession> getSessionMap(){
        return sessionMap;
    }
}
