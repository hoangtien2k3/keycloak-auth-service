package com.hoangtien2k3.authmodel.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserKeycloakRequest {
    private String id;
    private String username;
    private Boolean enabled;
    private String email;
}
