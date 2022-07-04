package com.caoBot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class caoBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException
    {
        // application.yml 에 token 저장
        String bot_token = "token";
        JDA jda = JDABuilder.createDefault(AccountType.BOT.name())
                .setToken(bot_token)
                .addEventListeners(new caoBot())
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
