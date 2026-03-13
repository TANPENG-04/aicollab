package com.pengtan.aicollab.util;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

public class DocumentWebSocketHandler extends TextWebSocketHandler {

    // 存储所有连接的用户（Virtual Threads 友好）
    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.put(session.getId(), session);
        System.out.println("✅ 新用户连接成功: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String payload = message.getPayload();
        System.out.println("收到消息: " + payload);

        // 广播给所有连接的用户（实时协作）
        sessions.values().forEach(s -> {
            try {
                s.sendMessage(new TextMessage("实时更新: " + payload));
            } catch (Exception e) {
                // 忽略断开的连接
            }
        });
    }
}