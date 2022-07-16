package com.caobot.application;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

@Service
public class CaoBotConnection {
    private static JDA jda;

    private static String bot_token;

    @Value("${user.token}")
    private void setBotToken(String value) {
        this.bot_token = value;
    }

    public static void start() {
        try {
            jda = JDABuilder.createDefault(AccountType.BOT.name())
                    .setToken(bot_token)
                    .addEventListeners(new MessageService())
                    .setActivity(Activity.watching("cao-bot 운영 중!"))
                    .build();

            System.out.println("Finished Building JDA!");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        jda.shutdown();
        System.out.println("Finished Stopping JDA!");
    }
}
