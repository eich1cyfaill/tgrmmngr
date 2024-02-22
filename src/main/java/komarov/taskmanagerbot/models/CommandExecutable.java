package komarov.taskmanagerbot.models;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@FunctionalInterface
public interface CommandExecutable<T, TelegramLongPollingBot, T1> {
    T1 executeCommand(Update update, TelegramLongPollingBot bot, String[] args) throws TelegramApiException;
}
