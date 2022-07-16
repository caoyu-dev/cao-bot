package com.caobot.application;

import net.dv8tion.jda.api.events.application.ApplicationCommandUpdateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends ListenerAdapter {
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
