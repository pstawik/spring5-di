package pl.pstawik.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Controller;
import pl.pstawik.sfgdi.services.GreetingService;

import java.util.Arrays;

@Controller
public class I18nController {

    private final GreetingService greetingService;

    @Autowired
    private ConfigurableEnvironment environment;

    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        Arrays.stream(environment.getActiveProfiles()).forEach(System.out::println);
        return greetingService.sayGreeting();
    }
}
