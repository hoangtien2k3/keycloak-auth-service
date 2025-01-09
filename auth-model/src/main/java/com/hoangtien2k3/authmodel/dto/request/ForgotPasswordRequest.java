package com.hoangtien2k3.authmodel.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {
    @NotEmpty(message = "dto.email.not.empty")
    @Size(max = 200, message = "dto.email.over.length")
    private String email;
    private String username;
}
