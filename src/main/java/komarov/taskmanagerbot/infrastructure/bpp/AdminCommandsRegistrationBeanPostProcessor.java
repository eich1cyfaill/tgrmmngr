package komarov.taskmanagerbot.infrastructure.bpp;

import komarov.taskmanagerbot.handlers.commands.CommandsHolder;
import komarov.taskmanagerbot.infrastructure.annotations.AdminCommand;
import komarov.taskmanagerbot.models.CommandMetaInformation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.lang.reflect.Method;

@Component
@DependsOn("commandsHolder")
public class AdminCommandsRegistrationBeanPostProcessor implements BeanPostProcessor {
    private CommandsHolder commandsHolder;
    @Autowired
    public AdminCommandsRegistrationBeanPostProcessor(CommandsHolder commandsHolder) {
        this.commandsHolder = commandsHolder;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        AdminCommand annotation = bean.getClass().getAnnotation(AdminCommand.class);
        if (annotation != null) {
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (Method m : methods) {
                // TODO: provide args for method invoke
                m.setAccessible(true);
                CommandMetaInformation cmi = (CommandMetaInformation) ReflectionUtils.invokeMethod(m, bean);
                if (cmi.getName() != null) {
                    commandsHolder.getCommandList().add(cmi.getName());
                    commandsHolder.getMappings().put(cmi.getName(), cmi.getFunction());
                    commandsHolder.getCommandObjects().add(new BotCommand(cmi.getName(), cmi.getDescription()));
                }
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
