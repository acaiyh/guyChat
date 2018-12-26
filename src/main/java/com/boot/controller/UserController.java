package com.boot.controller;

import com.boot.model.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TestController
 * @Auther: Administrator
 * @Date: 2018/11/15 0015 16:02
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService testService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "success";
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser(Long id){
        return testService.getUser(id);
    }



}
