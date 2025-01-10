package com.hoangtien2k3.authservice.client.impl;

import com.hoangtien2k3.authmodel.constants.UrlPaths;
import com.hoangtien2k3.authservice.client.NotiServiceClient;
import com.hoangtien2k3.notimodel.dto.request.CreateNotificationDTO;
import com.reactify.client.BaseRestClient;
import com.reactify.model.response.DataResponse;
import com.reactify.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@DependsOn("webClientFactory")
public class NotiServiceClientImpl implements NotiServiceClient {
    @Qualifier("notiServiceClient")
    private final WebClient notiServiceClient;

    private final BaseRestClient<DataResponse> baseRestClient;

    @Override
    public Mono<Optional<DataResponse>> insertTransmission(CreateNotificationDTO createNotificationDTO) {
        return SecurityUtils.getTokenUser().flatMap(token -> {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            return baseRestClient
                    .post(notiServiceClient,
                            UrlPaths.Noti.CREATE_NOTI,
                            headers,
                            createNotificationDTO,
                            DataResponse.class)
                    .doOnSuccess(result -> log.info("Call noti-service insert transmission result: {}", result))
                    .doOnError(error -> log.error("Error calling noti-service: ", error));
        });
    }
}
