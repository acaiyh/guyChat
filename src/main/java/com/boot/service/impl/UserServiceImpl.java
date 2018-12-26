package com.boot.service.impl;

import com.boot.dao.UserMapper;
import com.boot.model.User;
import com.boot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: TestServiceImpl
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 11:47
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
