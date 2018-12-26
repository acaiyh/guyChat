package com.boot.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName: RedisUtil
 * @Auther: Administrator
 * @Date: 2018/12/24 0024 17:38
 * @Description:
 */
public class RedisUtil {

    private static Jedis instance;

    public static Jedis instance(){
        if(instance == null){
            synchronized (RedisUtil.class){
                if(instance == null){
                    Properties properties = null;
                    try {
                        properties = PropertiesLoaderUtils.loadAllProperties("global.properties");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String host = properties.getProperty("redis.host");
                    int port = Integer.parseInt(properties.getProperty("redis.post"));
                    instance = new Jedis(host,port);
                }
            }
        }
        return instance;
    }

}
