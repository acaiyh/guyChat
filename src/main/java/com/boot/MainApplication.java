package com.boot;

import com.boot.socketThread.ChatTeread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: Main
 * @Auther: Administrator
 * @Date: 2018/11/15 0015 11:24
 * @Description:
 */
@SpringBootApplication
@MapperScan(value = "com.boot.dao")
public class MainApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }

    private ChatTeread chatTeread;
    private Thread thread;

    {
        chatTeread = new ChatTeread();
        thread = new Thread(chatTeread);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        thread.start();
    }

    @RequestMapping(value = "/stopChatThread")
    public void stopChatThread(){
        thread.interrupt();
    }
}