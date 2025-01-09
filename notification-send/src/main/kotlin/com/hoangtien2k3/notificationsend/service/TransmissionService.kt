package com.hoangtien2k3.notificationsend.service

import com.reactify.model.response.DataResponse
import reactor.core.publisher.Mono

interface TransmissionService {
    fun sendNotification(): Mono<DataResponse<Any>>
}