package org.dxc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "dxc.india.enabled", havingValue = "true")
public class DxcAutoConfiguration {

    @Bean
    public String dxcIndia() {
        return "Dxc-India";
    }

}
