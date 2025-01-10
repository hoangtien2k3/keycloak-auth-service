package com.hoangtien2k3.notisend.service

import com.hoangtien2k3.notimodel.dto.EmailResultDTO
import com.hoangtien2k3.notimodel.dto.TransmissionNotiDTO
import reactor.core.publisher.Mono

interface MailService {
    fun sendMailByTransmission(transmissionNotis: List<TransmissionNotiDTO>): Mono<List<EmailResultDTO>>
}