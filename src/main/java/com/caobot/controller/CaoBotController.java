package com.caobot.controller;

import com.caobot.application.CaoBotConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaoBotController {
    @GetMapping("/start")
    public void startCaoBot(){
        CaoBotConnection.start();
    }

//    @GetMapping("/stop")
//    public void stopCaoBot(){
//        BotConnection.stop();
//    }
}
