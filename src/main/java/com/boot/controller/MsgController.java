package com.boot.controller;

import io.socket.engineio.parser.Packet;
import io.socket.engineio.server.EngineIoSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: MsgController
 * @Auther: Administrator
 * @Date: 2018/12/3 0003 17:44
 * @Description:
 */
@Controller
@RequestMapping(value = "/msg")
public class MsgController {

    EngineIoSocket socket;

    @RequestMapping(value = "toMsg",method = RequestMethod.GET)
    public void sendMsg(String m){
        socket.send(new Packet<>(Packet.MESSAGE,m));
    }
}
