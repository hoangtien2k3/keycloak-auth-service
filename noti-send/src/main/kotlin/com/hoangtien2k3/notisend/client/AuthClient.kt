package com.hoangtien2k3.notisend.client

import com.hoangtien2k3.notimodel.dto.response.ContactResponse
import reactor.core.publisher.Mono

interface AuthClient {
    fun getContacts(userIds: List<String>): Mono<ContactResponse>
}
