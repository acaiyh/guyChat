package com.boot.model;

/**
 * @ClassName: ChatObject
 * @Auther: Administrator
 * @Date: 2018/12/10 0010 15:42
 * @Description:
 */
public class ChatObject extends User{

    private String userName;
    private String message;

    public ChatObject() {
    }

    public ChatObject(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
