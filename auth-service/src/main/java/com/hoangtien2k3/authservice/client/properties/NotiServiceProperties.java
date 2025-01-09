package com.hoangtien2k3.authservice.client.properties;

import com.reactify.client.properties.WebClientProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("notiServiceProperties")
@ConfigurationProperties(prefix = "client.notification", ignoreInvalidFields = true)
@Data
@AllArgsConstructor
public class NotiServiceProperties extends WebClientProperties {}
