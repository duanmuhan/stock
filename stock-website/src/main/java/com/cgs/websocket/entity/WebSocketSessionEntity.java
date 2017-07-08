package com.cgs.websocket.entity;

import org.springframework.util.ObjectUtils;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/8.
 */
public class WebSocketSessionEntity {

    private WebSocketSession webSocketSession;

    public WebSocketSessionEntity(WebSocketSession webSocketSession){
        this.webSocketSession = webSocketSession;
    }

    public synchronized void send(WebSocketMessage message) throws IOException {
        if (!ObjectUtils.isEmpty(webSocketSession)){
            webSocketSession.sendMessage(message);
        }
    }
}
