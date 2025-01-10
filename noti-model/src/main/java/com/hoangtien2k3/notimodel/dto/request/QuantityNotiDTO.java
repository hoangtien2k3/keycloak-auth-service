package com.hoangtien2k3.notimodel.dto.request;

import lombok.Builder;

@Builder
public record QuantityNotiDTO(Integer quantityNewNoti, Integer quantityUnreadNotices, Integer quantityUnreadNews) {}
