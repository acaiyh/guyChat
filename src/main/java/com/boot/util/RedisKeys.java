package com.boot.util;

/**
 * @ClassName: com.zqzr.financial.constant
 * @Auther: caiyunchun
 * @Date: 2018/10/17 0017 17:26
 * @Description:
 */
public class RedisKeys {

    //reids key 有效期
    public static int KEY_EXPIRE_30s = 30;
    public static int KEY_EXPIRE_60s = 60;
    public static int KEY_EXPIRE_2m = 120;
    public static int KEY_EXPIRE_3m = 180;
    public static int KEY_EXPIRE_5m = 300;
    public static int KEY_EXPIRE_10m = 600;
    public static int KEY_EXPIRE_30m = 3000;
    public static int KEY_EXPIRE_60m = 6000;

    public static String VERIFICATION_CODE = "verification_code";

    public static String HOME_PRODUCT_LIST = "home_product_list"; //首页列表

    public static String LOGIN_USER_SESSION = "app_user_token_code_";  //用户key

    public static final String TEXT_MESSAGE = "text_message_";      //短信

}
