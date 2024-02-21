package komarov.taskmanagerbot.models;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@FunctionalInterface
public interface CommandExecutable<T, TelegramLongPollingBot, T1> {
    public T1 executeCommand(Update update, TelegramLongPollingBot bot) throws TelegramApiException;
}
