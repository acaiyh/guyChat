package com.boot.util;

import java.util.Random;

/**
 * @ClassName: CommonUtil
 * @Auther: Administrator
 * @Date: 2018/12/18 0018 13:48
 * @Description:
 */
public class CommonUtil {

    public static String makeCode(int count){
        char[] chats = {'1','2','3','4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        String code = "";
        for(int i=0; i<count; i++){
            int index = random.nextInt(57);
            code += chats[index];
        }
        return code;
    }

}
