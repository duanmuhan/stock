package com.cgs.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@Component
@RequestMapping("/quotesHandler")
public class QuotesHandler extends BinaryWebSocketHandler {

    private SimpMessagingTemplate template;

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {

    }


}
