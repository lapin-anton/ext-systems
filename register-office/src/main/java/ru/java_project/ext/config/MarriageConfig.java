package ru.java_project.ext.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/register.properties"})
public class MarriageConfig {

}
