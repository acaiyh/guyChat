package com.boot.controller;

import com.boot.model.User;
import com.boot.model.common.ActionResultDto;
import com.boot.model.common.ResultDataType;
import com.boot.service.LoginService;
import com.boot.util.CommonUtil;
import com.boot.util.RedisKeys;
import com.boot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Auther: Administrator
 * @Date: 2018/12/17 0017 17:47
 * @Description:
 */
@Controller
@RequestMapping(value = "/login")
public class    LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/register")
    public void register(User user){
        loginService.register(user);
    }

    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public ActionResultDto doLogin(String username, String pwd, String code,String random, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        ActionResultDto dto = new ActionResultDto();
        //验证码校验
        String textCode = RedisUtil.instance().get(RedisKeys.VERIFICATION_CODE + random);
        if(code != null && code.length() > 0 && textCode != null && textCode.length() > 0){
            if(!code.equalsIgnoreCase(textCode)){
                dto.setCode(ResultDataType.CODE_ERROR.getCode());
                dto.setMessage(ResultDataType.CODE_ERROR.getMessage());
                return dto;
            }
        }
        User user = loginService.doLogin(username,pwd);
        if(user != null){
            dto.setData(user);
        }else{
            dto.setCode(ResultDataType.CODE_LOGIN_ERROR.getCode());
            dto.setMessage(ResultDataType.CODE_LOGIN_ERROR.getMessage());
        }
        return dto;
    }

    //生成验证码
    @RequestMapping(value = "/makeCode", method = RequestMethod.GET)
    @ResponseBody
    public Map makeCode(String random,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String code = CommonUtil.makeCode(4);
        RedisUtil.instance().set(RedisKeys.VERIFICATION_CODE + random,code);
        RedisUtil.instance().expire(RedisKeys.VERIFICATION_CODE,RedisKeys.KEY_EXPIRE_5m);
        request.getSession().setAttribute("code",code);
        Map map = new HashMap<>();
        map.put("code",code);
        return map;
    }

}
