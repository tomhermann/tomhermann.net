package net.tomhermann.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan(basePackages = "net.tomhermann", excludeFilters = { @Filter(Configuration.class) })
@PropertySource("config/application.properties")
public class ComponentConfig {
}
