package com.hoangtien2k3.notiservice.repository

import com.hoangtien2k3.notiservice.repository.query.TransmissionQuery
import com.hoangtien2k3.notimodel.dto.TransmissionNotiDTO
import com.hoangtien2k3.notimodel.dto.response.CountNoticeDTO
import com.hoangtien2k3.notimodel.model.NotificationContent
import com.hoangtien2k3.notimodel.model.Transmission
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface TransmissionRepository : R2dbcRepository<Transmission, String> {

    @Query(TransmissionQuery.getCountNoticeDTO)
    fun getListCountNoticeDTO(receiver: String): Flux<CountNoticeDTO>

    @Query(TransmissionQuery.getTransmissionByNotificationContentId)
    fun getListTransId(receiver: String, notificationContentId: String): Flux<String>

    @Query(TransmissionQuery.changeStateTransmissionByType)
    fun changeStateTransmissionByNotiIdAndReceiver(state: String, receiver: String, notificationContentId: String): Mono<Void>

    @Query(TransmissionQuery.getAllNotificationContentByCreateAtAfter)
    fun getAllNotificationContentByCreateAtAfter(receiver: String, newestNotiTime: LocalDateTime): Flux<NotificationContent>

    @Query(TransmissionQuery.findByIdAndStatus)
    fun findByIdAndStatus(id: String, status: Int): Mono<Transmission>

    @Query(TransmissionQuery.getTransmissionsToSendMail)
    fun getTransmissionsToSendMail(resendCount: Int): Flux<TransmissionNotiDTO>

    @Query(TransmissionQuery.updateTransmissionState)
    fun updateTransmissionSuccessState(transmissionIds: List<String>): Mono<Boolean>

    @Query(TransmissionQuery.updateTransmissionStateAndResendCount)
    fun updateTransmissionFailedState(transmissionIds: List<String>): Mono<Boolean>

    @Query(TransmissionQuery.updateStateById)
    fun updateTransmissionStateById(id: String, state: String): Mono<Boolean>
}
