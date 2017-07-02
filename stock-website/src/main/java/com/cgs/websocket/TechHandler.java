package com.cgs.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
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
        for (String key : sessionMap.keySet()){
            TextMessage  webSocketMessage = new TextMessage("test");
            sessionMap.get(key).sendMessage(webSocketMessage);
            boolean isOpen = sessionMap.get(key).isOpen();
            URI uri = session.getUri();
            String path = uri.getPath();
            long port = uri.getPort();
            System.out.println(key);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
    }

    public Map<String,WebSocketSession> getSessionMap(){
        return sessionMap;
    }
}
