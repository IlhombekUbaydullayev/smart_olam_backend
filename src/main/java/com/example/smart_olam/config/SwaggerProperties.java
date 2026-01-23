package com.example.smart_olam.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "custom.swagger")
public class SwaggerProperties {

    private String title = "API_document";
    private String description = "API Documentation new swagger";
    private String version = "1.0.0";
    private boolean enabled = true;

    // getters & setters
}

