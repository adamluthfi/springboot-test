package com.sample_spring.core;

import com.sample_spring.core.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class AwareTest {

    @Configuration
    @Import({
            AuthService.class
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
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);

        Assertions.assertNotNull("com.sample_spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
    }

    @Test
    public void testGetUserId() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, NoSuchProviderException, InvalidKeyException {
        var keympin = "qwJnvFlmGvSSXbb+H3japfPXtpP+xNnJpc1U1t/UCaU=";
        var secret = "paybox";
        // String encrypted = CryptoUtils.encryptMbankingPin(secret, keympin, "yogi42");

        //log.info("UserId: {}", encrypted);
    }
}
