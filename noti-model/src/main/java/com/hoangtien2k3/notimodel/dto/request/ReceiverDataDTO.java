package com.hoangtien2k3.notimodel.dto.request;

import lombok.Builder;

@Builder
public record ReceiverDataDTO(String userId, String email) {}
