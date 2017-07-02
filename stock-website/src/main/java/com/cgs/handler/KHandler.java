package com.cgs.handler;

import com.cgs.websocket.QuotesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.socket.WebSocketSession;

import javax.jms.MessageListener;
import java.util.Map;

@Component
public class KHandler implements MessageListener {

  @Autowired
  private QuotesHandler quotesHandler;

  @Override
  public void onMessage(javax.jms.Message message) {
    Map<String,WebSocketSession> sessionMap = quotesHandler.getSessionMap();
    if (!ObjectUtils.isEmpty(sessionMap)){
      for (String key : sessionMap.keySet()){
        //sessionMap.get(key).sendMessage();
      }
    }
  }
}
