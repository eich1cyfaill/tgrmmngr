package komarov.taskmanagerbot.executables;

import komarov.taskmanagerbot.models.CommandExecutable;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class GetDateExecutables {
    public CommandExecutable<Update, TelegramLongPollingBot, Void> getTodayDateExecutable() {
        return (update, bot) -> {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            bot.execute(sendMessage);
            return null;
        };
    }
}
