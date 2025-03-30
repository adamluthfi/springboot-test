package com.sample_spring.core;

import com.sample_spring.core.data.User;
import com.sample_spring.core.listener.LoginAgainSuccessListener;
import com.sample_spring.core.listener.LoginSuccessListener;
import com.sample_spring.core.listener.UserListener;
import com.sample_spring.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("adam", "adam");
        userService.login("adam", "salah");
        userService.login("lutfi", "salah");
    }
}
