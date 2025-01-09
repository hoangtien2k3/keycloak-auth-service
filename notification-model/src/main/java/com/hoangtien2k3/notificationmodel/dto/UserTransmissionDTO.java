package com.hoangtien2k3.notificationmodel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class UserTransmissionDTO {
    @JsonIgnoreProperties("transmission_id")
    private String transmissionId;
    private String email;
    @JsonProperty("template_mail")
    private String templateMail;
    @JsonProperty("create_at")
    private LocalDateTime createAt;
    private String state;
    @JsonProperty("create_by")
    private String createBy;
}