package komarov.taskmanagerbot.handlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public abstract class TokenizedLongPollingBot extends TelegramLongPollingBot {
    @Value("${token}")
    private String token;
    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return "Task Manager 0.1";
    }
}
