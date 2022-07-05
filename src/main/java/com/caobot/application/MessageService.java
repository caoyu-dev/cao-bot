package com.caobot.application;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.application.ApplicationCommandUpdateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

@Service
public class MessageService extends ListenerAdapter {
    private static String bot_token;

    @Value("${user.token}")
    private void setBotToken(String value) {
        this.bot_token = value;
    }

    public static void CaoBotLoad() throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(AccountType.BOT.name())
                .setToken(bot_token)
                .addEventListeners(new MessageService())
                .build();

        jda.awaitReady();
        System.out.println("Finished Building JDA!");
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

    @Override
    public void onApplicationCommandUpdate(ApplicationCommandUpdateEvent event)
    {

    }
}
