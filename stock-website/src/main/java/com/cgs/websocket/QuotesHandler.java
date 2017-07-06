package com.cgs.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class QuotesHandler extends BinaryWebSocketHandler {

    private Map<String,WebSocketSession> sessionMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSession> trendMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSession> kMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSession> marketPriceMap = new ConcurrentHashMap<>();
    private Map<String,WebSocketSession> tickMap = new ConcurrentHashMap<>();

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.put(session.getId(),session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
    }

    public Map<String,WebSocketSession> getSessionMap(){
        return sessionMap;
    }

    public Map<String, WebSocketSession> getTrendMap() {
        return trendMap;
    }

    public Map<String, WebSocketSession> getkMap() {
        return kMap;
    }

    public Map<String, WebSocketSession> getMarketPriceMap() {
        return marketPriceMap;
    }

    public Map<String, WebSocketSession> getTickMap() {
        return tickMap;
    }
}
