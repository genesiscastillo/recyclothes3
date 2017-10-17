package recyclothes3.web.websocket;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Cesar on 16-10-2017.
 */
@ClientEndpoint
public class GsonTest {

    private Session session;
    enum Connect {
        //LOCALHOST_8080("ws://localhost:8080/RecyclothesEAR-cdi/adminWebSocket"),
        LOCALHOST_8080("ws://localhost/fotoProductoWebSocket"),
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
        System.out.println("HOLA GSON TEST");
        GsonTest gsonTest = new GsonTest();
        gsonTest.connectToWebSocket(Connect.LOCALHOST_8080.getUrl());
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
        System.out.println("RECIBIENDO "+message);
    }

    @OnOpen
    public void open(Session session){
        this.session = session;
        System.out.println("ENVIANDO....!!");
        sendMessage("SEND HOLA MUNDO");
    }
    @OnClose
    public void close(){
        System.out.println("Close");
    }
    @OnError
    public void error(Throwable throwable){
        System.err.println(throwable.getMessage());
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
