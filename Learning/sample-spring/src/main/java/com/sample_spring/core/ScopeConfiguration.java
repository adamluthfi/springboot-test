package com.sample_spring.core;

import com.sample_spring.core.data.Bar;
import com.sample_spring.core.data.Foo;
import com.sample_spring.core.scope.DoubleToneScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Create new foo");
        return new Foo();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configure = new CustomScopeConfigurer();
        configure.addScope("doubleton", new DoubleToneScope());
        return configure;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar() {
        log.info("create new bar");
        return new Bar();
    }
}
