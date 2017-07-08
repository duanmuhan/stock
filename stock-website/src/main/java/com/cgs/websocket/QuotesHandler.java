package com.cgs.websocket;

import com.cgs.websocket.entity.WebSocketSessionEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class QuotesHandler extends TextWebSocketHandler {

    private Map<String,WebSocketSessionEntity> sessionMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSessionEntity> trendMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSessionEntity> kMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSessionEntity> marketPriceMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSessionEntity> tickMap = new ConcurrentHashMap<>();
    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        super.handleBinaryMessage(session, message);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        WebSocketSessionEntity webSocketEntity = new WebSocketSessionEntity(session);
        sessionMap.put(session.getId(),webSocketEntity);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
    }

    public Map<String,WebSocketSessionEntity> getSessionMap(){
        return sessionMap;
    }

    public Map<String, WebSocketSessionEntity> getTrendMap() {
        return trendMap;
    }

    public Map<String, WebSocketSessionEntity> getkMap() {
        return kMap;
    }

    public Map<String, WebSocketSessionEntity> getMarketPriceMap() {
        return marketPriceMap;
    }

    public Map<String, WebSocketSessionEntity> getTickMap() {
        return tickMap;
    }

}
