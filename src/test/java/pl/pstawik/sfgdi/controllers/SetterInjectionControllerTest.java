package pl.pstawik.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pstawik.sfgdi.services.ConstructorGreetingServiceImpl;

class SetterInjectionControllerTest {

    SetterInjectionController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectionController();
        controller.setGreetingService(new ConstructorGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}