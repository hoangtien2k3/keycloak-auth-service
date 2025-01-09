package com.hoangtien2k3.authmodel.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderLogin {
    @NotEmpty(message = "login.provider.code.not.empty")
    private String code;
}
