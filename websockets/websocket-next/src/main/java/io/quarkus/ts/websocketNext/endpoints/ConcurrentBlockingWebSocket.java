package io.quarkus.ts.websocketNext.endpoints;

import io.quarkus.websockets.next.InboundProcessingMode;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/concurrent", inboundProcessingMode = InboundProcessingMode.CONCURRENT)
public class ConcurrentBlockingWebSocket {

    @OnTextMessage
    public String onMessage(String message) throws InterruptedException {
        if (message.equals("block")) {
            Thread.sleep(1500);
        }
        return message;
    }
}
