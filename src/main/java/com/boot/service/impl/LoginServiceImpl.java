package com.boot.service.impl;

import com.boot.dao.UserMapper;
import com.boot.model.User;
import com.boot.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: LoginServiceImpl
 * @Auther: Administrator
 * @Date: 2018/12/18 0018 14:47
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserMapper userMapper;

    @Override
    public void register(User user) {

    }

    @Override
    public User doLogin(String username, String pwd) {
        User user = userMapper.selectByUP(username,pwd);
        return user;
    }
}
