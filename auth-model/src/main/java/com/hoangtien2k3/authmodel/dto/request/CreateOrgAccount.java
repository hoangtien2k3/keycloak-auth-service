package com.hoangtien2k3.authmodel.dto.request;

import com.hoangtien2k3.authmodel.dto.response.IndividualDTO;
import com.hoangtien2k3.authmodel.model.TenantIdentify;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrgAccount {
    @NotEmpty(message = "dto.email.not.empty")
    @Size(max = 200, message = "dto.email.over.length")
    private String email;

    @Length(max = 12, message = "organization.phone.over.length")
    @NotEmpty(message = "organization.phone.not.empty")
    private String phone;

    @Length(max = 255, message = "organization.name.over.length")
    @NotEmpty(message = "organization.name.not.empty")
    private String name;

    private LocalDateTime foundingDate;

    @NotNull(message = "organization.representative.null")
    private IndividualDTO representative;

    @NotNull(message = "organization.identify.null")
    private List<TenantIdentify> identifies;
}
