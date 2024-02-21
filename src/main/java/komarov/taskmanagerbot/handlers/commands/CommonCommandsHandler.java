package komarov.taskmanagerbot.handlers.commands;

import komarov.taskmanagerbot.handlers.TokenizedLongPollingBot;
import komarov.taskmanagerbot.models.CommandExecutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

@Component
public class CommonCommandsHandler extends TokenizedLongPollingBot {
    private CommandsHolder commandsHolder;
    @Autowired
    public CommonCommandsHandler(CommandsHolder commandsHolder) {
        this.commandsHolder = commandsHolder;
    }

    /**
     * If our prompt begins with '/' then split our prompt into array, take first element as a command, that helps
     * us find callback in hashmap and other elems in array assume as arguments.
     * Getting functionalInterfaceWrapper from HashMap and casting our Object into class kept in wrapper.
     * Then invoke method (only one as this a func. interface);
     * @param update
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().charAt(0) == '/') {
            String[] prompt = update.getMessage().getText().split(" ");
            String cmd = prompt[0];
            if (cmd.length() > 1) {
                cmd = cmd.substring(1, cmd.length());
            }
            String[] args = Arrays.copyOfRange(prompt, 1, prompt.length);

            try {
                CommandExecutable<Update, TelegramLongPollingBot, ?> commandExecutable = commandsHolder.getMappings().get(cmd);
                commandExecutable.executeCommand(update, this);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
