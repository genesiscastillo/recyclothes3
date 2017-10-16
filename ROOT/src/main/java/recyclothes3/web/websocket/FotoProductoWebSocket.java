package recyclothes3.web.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Cesar on 16-10-2017.
 */
@ServerEndpoint("/fotoProductoWebSocket")
public class FotoProductoWebSocket {

    @OnOpen
    public void open(Session session) {

    }

    @OnClose
    public void close(Session session) {
    }

    @OnError
    public void onError(Throwable error) {
    }

    @OnMessage
    public void handleMessage(String message, Session session) {

    }
}