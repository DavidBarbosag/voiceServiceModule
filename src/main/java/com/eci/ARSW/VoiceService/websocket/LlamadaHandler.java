package com.eci.ARSW.VoiceService.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LlamadaHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sesiones = ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sesiones.add(session);
        System.out.println("Cliente conectado: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Mensaje recibido de " + session.getId() + ": " + payload);

        // Reenvía a todos menos al remitente
        for (WebSocketSession s : sesiones) {
            if (!s.getId().equals(session.getId()) && s.isOpen()) {
                s.sendMessage(message);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sesiones.remove(session);
        System.out.println("Cliente desconectado: " + session.getId());
    }
}
