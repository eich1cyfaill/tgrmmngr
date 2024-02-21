package komarov.taskmanagerbot.listeners;

import komarov.taskmanagerbot.clients.RestAdminCommandsPusherClient;
import komarov.taskmanagerbot.exceptions.ReturnedUnsatisfiedResponseException;
import komarov.taskmanagerbot.handlers.commands.CommandsHolder;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CommandPushingListener implements ApplicationListener<ContextRefreshedEvent> {
    private CommandsHolder commandsHolder;
    private RestAdminCommandsPusherClient adminCommandsClient;

    @Autowired
    public CommandPushingListener(CommandsHolder commandsHolder, RestAdminCommandsPusherClient adminCommandsClient) {
        this.commandsHolder = commandsHolder;
        this.adminCommandsClient = adminCommandsClient;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!adminCommandsClient.isPushed()) {
            // ...
            try {
                // TODO: Impl Retry pattern
                adminCommandsClient.pushAdminCommands(commandsHolder.getCommandObjects());
                adminCommandsClient.setPushed(true);
                System.out.println("Pushed admin commands, switching flag to true");
            } catch (ReturnedUnsatisfiedResponseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
