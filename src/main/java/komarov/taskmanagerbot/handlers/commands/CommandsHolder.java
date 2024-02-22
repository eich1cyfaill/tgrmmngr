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
    private Set<String> adminCommandList;
    private Set<String> userCommandList;
    private List<BotCommand> commandObjects;
    private Map<String, CommandExecutable<Update, TelegramLongPollingBot, ?>> mappings;

    @PostConstruct
    public void initMethod() {
        this.userCommandList = new HashSet<>();
        this.adminCommandList = new HashSet<>();
        this.commandObjects = new ArrayList<>();
        this.mappings = new HashMap<>();
    }
}
