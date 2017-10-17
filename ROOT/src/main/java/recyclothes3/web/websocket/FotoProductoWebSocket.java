package recyclothes3.web.websocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Cesar on 16-10-2017.
 */
@ServerEndpoint("/fotoProductoWebSocket")
public class FotoProductoWebSocket {

    private final static Logger LOGGER = Logger.getLogger(FotoProductoWebSocket.class);

    @OnOpen
    public void open(Session session) {
        LOGGER.info("****************************");
        LOGGER.info("open->"+session.getId());
        LOGGER.info("****************************");
    }

    @OnClose
    public void close(Session session) {
        LOGGER.info("****************************");
        LOGGER.info("close->"+session.getId());
        LOGGER.info("****************************");
    }

    @OnError
    public void onError(Throwable error) {
        LOGGER.info("****************************");
        LOGGER.error("Error websocket->"+error.getMessage());
        LOGGER.info("****************************");
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        LOGGER.info("****************************");
        LOGGER.info("handleMessage->"+message);
        LOGGER.info("****************************");
    }
}