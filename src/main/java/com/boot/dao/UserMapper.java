package com.boot.dao;

import com.boot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByPhone(String phone);

    User selectByUP(@Param(value = "username") String username, @Param(value = "pwd") String pwd);
}