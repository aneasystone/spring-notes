package com.stonie.springnotes.config;

import com.stonie.springnotes.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfig {

    //@Bean(initMethod = "init", destroyMethod = "destroy")
    @Bean
    @Scope("prototype")
    public TestService testService() {
        return new TestService();
    }
}
