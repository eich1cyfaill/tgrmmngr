package komarov.taskmanagerbot.executables;

import komarov.taskmanagerbot.models.CommandExecutable;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class GetHelpExecutables {
    public CommandExecutable<Update, TelegramLongPollingBot, Void> getHelp() {
        return (update, bot, args) -> {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("This text of block is about to help user! Will change over time");
            bot.execute(sendMessage);
            return null;
        };
    }
}
