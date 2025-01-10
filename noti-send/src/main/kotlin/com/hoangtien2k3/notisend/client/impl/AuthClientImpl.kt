package com.hoangtien2k3.notisend.client.impl

import com.hoangtien2k3.notisend.client.AuthClient
import com.hoangtien2k3.notimodel.dto.response.ContactResponse
import com.reactify.client.BaseRestClient
import lombok.extern.slf4j.Slf4j
import org.reflections.Reflections.log
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.DependsOn
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Slf4j
@Service
@DependsOn("webClientFactory")
class AuthClientImpl(
    private val baseRestClient: BaseRestClient<ContactResponse>,
    @Qualifier("auth") private val auth: WebClient
) : AuthClient {

    override fun getContacts(userIds: List<String>): Mono<ContactResponse> {
        return auth.method(HttpMethod.GET)
            .uri("/user/contacts")
            .bodyValue(userIds)
            .retrieve()
            .bodyToMono(ContactResponse::class.java)
            .onErrorResume { throwable ->
                log.info("Email list not found")
                Mono.just(ContactResponse())
            }
    }
}