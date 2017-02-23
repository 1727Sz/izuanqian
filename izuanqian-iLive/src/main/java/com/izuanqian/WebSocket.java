/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import java.io.IOException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author sanlion
 */
@ServerEndpoint("/ws")
@Component
public class WebSocket {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("open");
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        System.out.println("收到的消息：" + session);
        session.getBasicRemote().sendText("原封不动的返回给你：" + message);
    }
}
