package com.hoangtien2k3.notificationservice.repository

import com.ezbuy.notificationmodel.model.Notification
import com.ezbuy.notificationservice.repository.query.NotificationQuery
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface NotificationRepository : R2dbcRepository<Notification, String> {

    override fun findById(id: String): Mono<Notification>

    @Query(NotificationQuery.insertNotification)
    fun insert(
        id: String,
        sender: String,
        severity: String,
        notificationContentId: String,
        contentType: String,
        createAt: LocalDateTime,
        createBy: String,
        updateAt: LocalDateTime,
        updateBy: String,
        categoryId: String,
        status: Int,
        expectSendTime: LocalDateTime
    ): Mono<Void>
}
