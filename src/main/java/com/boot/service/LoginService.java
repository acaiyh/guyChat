package com.boot.service;

import com.boot.model.User;

/**
 * @ClassName: LoginService
 * @Auther: Administrator
 * @Date: 2018/12/17 0017 17:50
 * @Description:
 */
public interface LoginService {

    void register(User user);

    User doLogin(String username, String pwd);
}
