package komarov.taskmanagerbot.clients;

import komarov.taskmanagerbot.exceptions.ReturnedUnsatisfiedResponseException;
import komarov.taskmanagerbot.requests.SetMyCommandsRequest;
import komarov.taskmanagerbot.responses.SetMyCommandsRs;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

@Component
@Data
public class RestAdminCommandsPusherClient {
    @Value("${token}")
    private String token;

    private boolean pushed = false;

    public void pushAdminCommands(List<BotCommand> commandList) throws ReturnedUnsatisfiedResponseException {
        String url = "https://api.telegram.org/bot" + token + "/setMyCommands";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<SetMyCommandsRequest> httpEntity = new HttpEntity<>(new SetMyCommandsRequest(commandList));
        SetMyCommandsRs response = restTemplate.postForObject(url, httpEntity, SetMyCommandsRs.class);
        System.out.println(response.isResult());
        if (!response.isResult()) throw new ReturnedUnsatisfiedResponseException();
    }
}
