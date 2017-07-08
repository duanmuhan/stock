package com.cgs.websocket;

import com.cgs.websocket.entity.WebSocketSessionEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequestMapping("/tech-handler")
public class TechHandler extends TextWebSocketHandler {

    private Map<String,WebSocketSessionEntity> sessionMap = new ConcurrentHashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        WebSocketSessionEntity webSocketSessionEntity = new WebSocketSessionEntity(session);
        sessionMap.put(session.getId(),webSocketSessionEntity);
        WebSocketMessage webSocketMessage = new TextMessage("test");
        session.sendMessage(webSocketMessage);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("closed");
        sessionMap.remove(session.getId());
    }

    public Map<String,WebSocketSessionEntity> getSessionMap(){
        return sessionMap;
    }
}
