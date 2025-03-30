package com.sample_spring.core;

import com.sample_spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.sample_spring.core.service",
        "com.sample_spring.core.repository",
        "com.sample_spring.core.configuration"
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
