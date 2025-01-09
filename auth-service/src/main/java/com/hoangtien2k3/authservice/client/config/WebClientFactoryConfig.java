package com.hoangtien2k3.authservice.client.config;

import com.hoangtien2k3.authservice.client.properties.KeycloakClientProperties;
import com.reactify.client.WebClientFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;

@Configuration
@RequiredArgsConstructor
public class WebClientFactoryConfig {
    private final KeycloakClientProperties keycloakClientProperties;

    @Bean(name = "webClientFactory")
    public WebClientFactory webClientFactory(
            ApplicationContext applicationContext, ReactiveOAuth2AuthorizedClientManager authorizedClientManager) {
        WebClientFactory factory = new WebClientFactory(applicationContext, authorizedClientManager);
        factory.setWebClients(List.of(keycloakClientProperties));
        return factory;
    }
}
