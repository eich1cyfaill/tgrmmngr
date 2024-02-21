package komarov.taskmanagerbot.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SetMyCommandsRequest {
    private final List<BotCommand> commands;
    private final BotCommandScope scope = new BotCommandScopeDefault();
    private String language_code = "";
}
