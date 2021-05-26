package karmanchik.clientservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "karmanchik/clientservice/entity")
@EnableJpaRepositories(basePackages = "karmanchik.clientservice.jpa")
public class DataSourceConfig {
}
