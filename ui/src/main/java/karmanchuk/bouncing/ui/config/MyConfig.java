package karmanchuk.bouncing.ui.config;

import karmanchik.clientservice.config.DataSourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DataSourceConfig.class})
public class MyConfig {
}
