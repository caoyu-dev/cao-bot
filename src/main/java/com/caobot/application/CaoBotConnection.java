package com.caobot.application;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

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
//                    .setActivity(Activity.watching("I am Cao-Bot!"))
                    .build();

            jda.awaitReady();
            System.out.println("Finished Building JDA!");
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void stop() {
//        jda.shutdown();
//        System.out.println("Finished shutdown JDA!");
//    }
}
