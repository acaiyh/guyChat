package com.boot.socketThread;

import com.boot.model.ChatObject;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * guyChat 尬聊
 * @ClassName: ChatTeread
 * @Auther: Administrator
 * @Date: 2018/12/10 0010 17:42
 * @Description:
 */
public class ChatTeread implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(ChatObject.class);

    @Override
    public void run() {
        System.out.println("正在启动。。。");
        System.out.println("正在初始化。。。Socket.io|");
        System.out.println("读取配置文件。。。");
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("global.properties");
        } catch (IOException e) {
            logger.error("读取配置失败",e);
            e.printStackTrace();
        }
        String hostname = properties.getProperty("socket.hostname");
        int port = Integer.parseInt(properties.getProperty("socket.port"));
        Configuration configuration = new Configuration();
        configuration.setHostname(hostname);
        configuration.setPort(port);

        System.out.println("启动监听。。。");
        SocketIOServer server = new SocketIOServer(configuration);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                String joinMsg = "尬聊员：" + socketIOClient.getSessionId() + "加入尬聊！";
                System.out.println(joinMsg);
            }
        });
        server.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient socketIOClient) {
                String joinMsg = "尬聊员：" + socketIOClient.getSessionId() + "离开尬聊！";
                System.out.println(joinMsg);
            }
        });
        server.addEventListener("chatevent", ChatObject.class, (client, data, ackRquest) -> {
            //broadcast messages to all clients
            server.getBroadcastOperations().sendEvent("chatevent",data);
        });
        server.start();
        System.out.println("server have already started ...");
    }
}
