package com.caobot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class CaoBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException
    {
        // application.yml 에 token 저장
        String bot_token = "OTkxMDA3ODkyNDk4OTY4NjM2.GWxgsD.D45VodIk4J3GpxrZOBoja9zTH7vJCuIFcC2Ko0";
        JDA jda = JDABuilder.createDefault(AccountType.BOT.name())
                .setToken(bot_token)
                .addEventListeners(new CaoBot())
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().equals("!name")) {
            event.getChannel().sendMessage("cao-bot").queue();
        }
    }
}
