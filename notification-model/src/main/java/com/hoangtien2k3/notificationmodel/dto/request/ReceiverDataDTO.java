package com.hoangtien2k3.notificationmodel.dto.request;

import lombok.Builder;

@Builder
public record ReceiverDataDTO(String userId, String email) {}
