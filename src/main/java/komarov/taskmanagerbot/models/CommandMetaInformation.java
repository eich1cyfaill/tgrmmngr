package komarov.taskmanagerbot.models;

import lombok.Data;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.Function;

@Data
public class CommandMetaInformation {
    private String name;
    private String description;
    private CommandExecutable<Update, TelegramLongPollingBot, ?> function;
}
