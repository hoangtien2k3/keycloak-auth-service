package com.hoangtien2k3.notificationmodel.dto.request;

import lombok.Builder;

@Builder
public record QuantityNotiDTO(Integer quantityNewNoti, Integer quantityUnreadNotices, Integer quantityUnreadNews) {}
