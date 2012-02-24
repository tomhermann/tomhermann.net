package net.tomhermann.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/*** This configuration class is responsible for configuring cross-cutting concerns in the application. */
@Configuration
@ComponentScan(basePackages = "net.tomhermann", excludeFilters = { @Filter(Configuration.class) })
@ImportResource("classpath:spring/*-context.xml")
@PropertySource("config/application.properties")
public class ApplicationConfig {
}
