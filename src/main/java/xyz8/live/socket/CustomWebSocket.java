package xyz8.live.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@ServerEndpoint(value = "/test/{param}")
@Component
public class CustomWebSocket {

    private static AtomicInteger onlineCount = new AtomicInteger(0);


    @OnOpen
    public void onOpen(Session session, @PathParam("param") String param) {

        String queryString = session.getQueryString();
        System.out.println("param is :" + param);
        System.out.println("queryString is = " + queryString);
        
        onlineCount.incrementAndGet(); // 在线数加1
        log.info("有新连接加入：{}，当前在线数为：{}", session.getId(), onlineCount.get());
    }

    @OnClose
    public void onClose(Session session) {
        onlineCount.decrementAndGet(); // 在线数减1
        log.info("有一连接关闭：{}，当前在线数为：{}", session.getId(), onlineCount.get());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务端收到客户端[{}]的消息:{}", session.getId(), message);
        broadcast(session,message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public  void broadcast(Session session,String message){
            //同步异步说明参考：websocket getAsyncRemote()和getBasicRemote()区别
            //this.session.getBasicRemote().sendText(message);
            session.getAsyncRemote().sendText(message);
    }
}