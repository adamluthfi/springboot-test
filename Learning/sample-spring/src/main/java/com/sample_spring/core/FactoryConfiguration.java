package com.sample_spring.core;

import com.sample_spring.core.factory.PaymentGatewayFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PaymentGatewayFactoryBean.class
})
public class FactoryConfiguration {
}
