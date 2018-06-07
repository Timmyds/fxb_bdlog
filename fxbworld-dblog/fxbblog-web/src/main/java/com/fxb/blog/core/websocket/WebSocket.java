
package com.fxb.blog.core.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocket {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocket.class);
    /**
     * 初始在线人数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);
    /**
     * 线程安全的socket集合
     */
    private static CopyOnWriteArraySet<Session> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        webSocketSet.add(session);
        onlineCount.incrementAndGet();
        LOG.info("有链接加入，当前在线人数为: {}", getOnlineCount());
        WebSocketUtil.broadcast(getOnlineCount(), webSocketSet);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        onlineCount.decrementAndGet();
        LOG.info("有链接关闭,当前在线人数为: {}", getOnlineCount());
        WebSocketUtil.broadcast(getOnlineCount(), webSocketSet);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     *         客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        LOG.info("{}来自客户端的消息:{}", session.getId(), message);
        WebSocketUtil.sendMessage(message, session);
    }

    private String getOnlineCount() {
        return Integer.toString(onlineCount.get());
    }
}
