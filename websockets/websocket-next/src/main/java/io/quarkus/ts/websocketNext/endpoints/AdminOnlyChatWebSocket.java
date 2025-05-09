package io.quarkus.ts.websocketNext.endpoints;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

import io.quarkus.security.ForbiddenException;
import io.quarkus.security.UnauthorizedException;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.websockets.next.OnError;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/adminOnlyChat")
@RolesAllowed("admin")
public class AdminOnlyChatWebSocket {
    @Inject
    SecurityIdentity currentIdentity;

    @OnTextMessage(broadcast = true)
    public String echo(String message) {
        return currentIdentity.getPrincipal().getName() + ": " + message;
    }

    @OnError
    public String error(ForbiddenException t) {
        return "forbidden: " + currentIdentity.getPrincipal().getName();
    }

    @OnError
    public String error(UnauthorizedException t) {
        return "forbidden anonymous";
    }
}
