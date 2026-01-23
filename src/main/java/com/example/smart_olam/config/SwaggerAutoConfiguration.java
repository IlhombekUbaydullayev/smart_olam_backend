package com.example.smart_olam.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnProperty(
        prefix = "custom.swagger",
        name = "enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class SwaggerAutoConfiguration {

    @Bean
    public OpenAPI openAPI(SwaggerProperties props) {
        return new OpenAPI()
                .info(new Info()
                        .title(props.getTitle())
                        .description(props.getDescription())
                        .version(props.getVersion()));
    }
}
