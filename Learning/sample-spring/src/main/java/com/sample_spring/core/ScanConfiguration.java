package com.sample_spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sample_spring.core.configuration"})
public class ScanConfiguration {
}
