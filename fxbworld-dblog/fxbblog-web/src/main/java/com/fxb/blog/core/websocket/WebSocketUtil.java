
package com.fxb.blog.core.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Set;

/**
 * websocket工具类，支持单条发送和批量发送
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
public class WebSocketUtil {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketUtil.class);

    private WebSocketUtil() {
        // 私有化构造方法，禁止new
    }

    /**
     * 向客户端发送消息
     *
     * @param message
     *         消息内容
     * @param session
     *         客户端session
     * @throws IOException
     */
    public static void sendMessage(String message, Session session) {
        try {
            session.getAsyncRemote().sendText(message);
        } catch (Exception e) {
            LOG.error("websocket-->向客户端发送数据发生异常", e);
        }
    }

    /**
     * 群发
     *
     * @param message
     *         消息内容
     * @param sessionSet
     *         客户端session列表
     * @throws IOException
     */
    public static void broadcast(String message, Set<Session> sessionSet) {
        // 多线程群发
        for (Session entry : sessionSet) {
            if (entry.isOpen()) {
                sendMessage(message, entry);
            } else {
                sessionSet.remove(entry);
            }
        }
    }
}
