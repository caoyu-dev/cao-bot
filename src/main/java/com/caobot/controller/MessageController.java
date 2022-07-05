package com.caobot.controller;

import com.caobot.application.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
public class MessageController {

    @GetMapping("/")
    public void loadCaoBot() throws LoginException, InterruptedException {
        MessageService.CaoBotLoad();
    }
}
