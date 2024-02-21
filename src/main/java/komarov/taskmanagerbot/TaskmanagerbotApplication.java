package komarov.taskmanagerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TaskmanagerbotApplication {
    public static void main(String[] args) throws TelegramApiException {
        ConfigurableApplicationContext ctx = SpringApplication.run(TaskmanagerbotApplication.class, args);
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
       // api.registerBot(ctx.getBean("testEchoHandler", TelegramLongPollingBot.class));
        api.registerBot(ctx.getBean("commonCommandsHandler", TelegramLongPollingBot.class));
    }

}
