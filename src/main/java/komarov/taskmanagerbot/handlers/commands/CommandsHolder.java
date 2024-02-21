package komarov.taskmanagerbot.handlers.commands;

import jakarta.annotation.PostConstruct;
import komarov.taskmanagerbot.models.CommandExecutable;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.*;


@Component
@Getter
public class CommandsHolder {
    private Set<String> commandList;
    private List<BotCommand> commandObjects;
    private Map<String, CommandExecutable<Update, TelegramLongPollingBot, ?>> mappings;

    public CommandsHolder() {}

    public CommandsHolder(Set<String> commandList, List<BotCommand> commandObjects, Map<String, CommandExecutable<Update, TelegramLongPollingBot, ?>> mappings) {
        this.commandList = commandList;
        this.commandObjects = commandObjects;
        this.mappings = mappings;
    }

    @PostConstruct
    public void initMethod() {
        this.commandList = new HashSet<>();
        this.commandObjects = new ArrayList<>();
        this.mappings = new HashMap<>();
    }
}
