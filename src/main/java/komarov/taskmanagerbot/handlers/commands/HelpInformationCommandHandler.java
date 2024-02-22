package komarov.taskmanagerbot.handlers.commands;

import komarov.taskmanagerbot.executables.GetHelpExecutables;
import komarov.taskmanagerbot.infrastructure.annotations.UserCommand;
import komarov.taskmanagerbot.models.CommandMetaInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

@Component
@UserCommand
@DependsOn("commandsHolder")
public class HelpInformationCommandHandler {
    private final GetHelpExecutables executables;

    @Autowired
    public HelpInformationCommandHandler(GetHelpExecutables executables) {
        this.executables = executables;
    }

    public CommandMetaInformation getHelp() {
        CommandMetaInformation cmi = new CommandMetaInformation();
        cmi.setName("help");
        cmi.setDescription("Explain functionality of bot, list main commands to use");

        BotCommand botCommand = new BotCommand();
        botCommand.setCommand(cmi.getName());
        botCommand.setDescription(cmi.getDescription());

        cmi.setFunction(executables.getHelp());
        return cmi;
    }
}
