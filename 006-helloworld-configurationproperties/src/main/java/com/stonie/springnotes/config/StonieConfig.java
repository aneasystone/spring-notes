package com.stonie.springnotes.config;

import com.stonie.springnotes.properties.StonieProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StonieProperties.class)
public class StonieConfig {
}
