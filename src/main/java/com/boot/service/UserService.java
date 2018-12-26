package com.boot.service;

import com.boot.dao.UserMapper;
import com.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: UserService
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 11:45
 * @Description:
 */
public interface UserService {

    User getUser(Long id);
}
