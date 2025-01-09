package com.hoangtien2k3.notificationservice.controller

import com.ezbuy.notificationmodel.common.ConstValue.ControllerPath.TRANSMISSION_PATH
import com.ezbuy.notificationmodel.common.ConstValue.NotificationConstant.ANNOUNCEMENT
import com.ezbuy.notificationmodel.dto.UserTransmissionPageDTO
import com.ezbuy.notificationmodel.dto.request.CreateNotificationDTO
import com.ezbuy.notificationmodel.dto.request.GetTransmissionByEmailAndFromToRequest
import com.ezbuy.notificationmodel.dto.response.CountNoticeResponseDTO
import com.ezbuy.notificationmodel.dto.response.NotificationHeader
import com.ezbuy.notificationmodel.model.NotificationContent
import com.ezbuy.notificationservice.service.TransmissionService
import com.reactify.model.response.DataResponse
import com.reactify.util.DataUtil
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import kotlin.math.max

@RestController
@RequestMapping(TRANSMISSION_PATH)
class TransmissionController(
    private val transmissionService: TransmissionService
) {

    @PreAuthorize("hasAnyAuthority('user')")
    @GetMapping("/unread-noti")
    fun getQuantityUserNewNoti(): Mono<DataResponse<CountNoticeResponseDTO>> {
        return transmissionService.getCountNoticeResponseDTO()
    }

    @PreAuthorize("hasAnyAuthority('user')")
    @GetMapping("/noti")
    fun getNotificationContentListByCategoryType(
        @Valid @RequestParam(required = false, defaultValue = ANNOUNCEMENT) categoryType: String,
        @Valid @RequestParam(required = false, defaultValue = "1") pageIndex: Int?,
        @Valid @RequestParam(required = false, defaultValue = "20") pageSize: Int?,
        @Valid @RequestParam(required = false, defaultValue = "-createAt") sort: String?
    ): Mono<DataResponse<List<NotificationHeader>>> {
        return transmissionService.getNotificationContentListByCategoryType(categoryType, pageIndex, pageSize, sort)
    }

    @PreAuthorize("hasAnyAuthority('user')")
    @PutMapping("/change-noti-state")
    fun updateTransmissionState(
        @Valid @RequestParam(required = false) state: String,
        @Valid @RequestParam(required = false) notificationContentId: String,
        @Valid @RequestParam(required = false) transmissionId: String
    ): Mono<DataResponse<Any>> {
        return transmissionService.changeTransmissionStateByIdAndReceiver(state, notificationContentId, transmissionId)
    }

    @PreAuthorize("hasAnyAuthority('admin','system')")
    @PostMapping("/create-noti")
    fun insertTransmission(
        @Valid @RequestBody createNotificationDTO: CreateNotificationDTO
    ): Mono<DataResponse<Any>> {
        return transmissionService.insertTransmission(createNotificationDTO)
    }

    @PreAuthorize("hasAnyAuthority('user')")
    @GetMapping("/new-noti")
    fun getNewNotiWhenOnline(
        @RequestParam(required = false) @Size(message = "params.invalid.format", max = 50) newestNotiTime: String
    ): Mono<DataResponse<List<NotificationContent>>> {
        return transmissionService.getNewNotiWhenOnline(newestNotiTime)
    }

    @PreAuthorize("hasAnyAuthority('admin','system')")
    @GetMapping("/get-trans")
    fun getUserTransmission(
        @RequestParam(required = false) email: String?,
        @RequestParam(required = false) username: String?,
        @RequestParam(required = false, name = "template_mail") templateMail: String?,
        @RequestParam(required = false) from: String?,
        @RequestParam(required = false) to: String?,
        @RequestParam(required = false, defaultValue = "1") pageIndex: Int,
        @RequestParam(required = false, defaultValue = "10") pageSize: Int?,
        @RequestParam(required = false, defaultValue = "-create_at") sort: String?
    ): Mono<DataResponse<UserTransmissionPageDTO>> {
        var pageIndex = pageIndex
        pageIndex = max(pageIndex.toDouble(), 1.0).toInt()
        val request = GetTransmissionByEmailAndFromToRequest.builder()
            .email(DataUtil.safeTrim(email)).username(DataUtil.safeTrim(username))
            .templateMail(DataUtil.safeTrim(templateMail))
            .from(from).to(to)
            .pageIndex(pageIndex)
            .pageSize(pageSize)
            .limit(pageSize)
            .sort(sort)
            .build()
        return transmissionService.getTransmissionByEmailAndFromTo(request)
    }

}
