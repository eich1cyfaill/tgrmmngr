package komarov.taskmanagerbot.handlers.commands;

import komarov.taskmanagerbot.executables.GetDateExecutables;
import komarov.taskmanagerbot.infrastructure.annotations.AdminCommand;
import komarov.taskmanagerbot.models.CommandExecutable;
import komarov.taskmanagerbot.models.CommandMetaInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

@Component
@AdminCommand
@DependsOn("commandsHolder")
public class DateInformationCommandHandler {
    private GetDateExecutables executables;

    @Autowired
    public DateInformationCommandHandler(GetDateExecutables executables) {
        this.executables = executables;
    }

    public CommandMetaInformation getTodayDate() {
        BotCommand botCommand = new BotCommand();
        CommandMetaInformation cmi = new CommandMetaInformation();
        cmi.setName("today");
        cmi.setDescription("Get a date for today");
        cmi.setFunction(executables.getTodayDateExecutable());
        botCommand.setCommand(cmi.getName());
        botCommand.setDescription(cmi.getDescription());
        return cmi;
    }
}
