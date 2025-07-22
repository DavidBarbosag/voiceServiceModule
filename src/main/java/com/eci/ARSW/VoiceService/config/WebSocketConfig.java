package com.eci.ARSW.VoiceService.config;

import com.eci.ARSW.VoiceService.websocket.LlamadaHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final LlamadaHandler llamadaHandler;

    public WebSocketConfig(LlamadaHandler llamadaHandler) {
        this.llamadaHandler = llamadaHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(llamadaHandler, "/signal-ws")
                .setAllowedOrigins("*");  // Ajusta dominios permitidos
    }
}
