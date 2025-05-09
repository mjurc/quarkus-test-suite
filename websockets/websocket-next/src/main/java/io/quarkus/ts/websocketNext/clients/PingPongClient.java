package io.quarkus.ts.websocketNext.clients;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.websockets.next.OnPingMessage;
import io.quarkus.websockets.next.OnPongMessage;
import io.quarkus.websockets.next.WebSocketClient;
import io.vertx.core.buffer.Buffer;

@WebSocketClient(path = "/pingPong")
public class PingPongClient {
    public static List<Long> pingsReceived = new ArrayList<>();
    public static List<Long> pongsReceived = new ArrayList<>();

    @OnPingMessage
    void ping(Buffer data) {
        pingsReceived.add(System.currentTimeMillis());
    }

    @OnPongMessage
    void pong(Buffer data) {
        pongsReceived.add(System.currentTimeMillis());
    }
}
