package recyclothes3.web.websocket;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Cesar on 16-10-2017.
 */
@ClientEndpoint
public class GsonTest {
    enum Connect {
        LOCALHOST_8080("ws://localhost:8080/RecyclothesEAR-cdi/adminWebSocket"),
        WWW_RECYCLOTHES_CL("ws://web-babycaprichitos.rhcloud.com:8000/RecyclothesEAR-cdi/adminWebSocket");

        private String url;
        Connect(String url){
            this.url = url;
        }
        public String getUrl(){
            return this.url;
        }
    }

    public static void main(String... args){
        System.out.print("HOLA GSON TEST");
    }
    private void connectToWebSocket(String urlEndpointWebSocket) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            URI uri = URI.create(urlEndpointWebSocket);
            container.connectToServer(this, uri);
        } catch (DeploymentException | IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    @OnMessage
    public void handlerMessage(String message)  {

    }

    @OnOpen
    public void open(Session session){

    }
    @OnClose
    public void close(){

    }
    @OnError
    public void error(Throwable throwable){

    }
}
