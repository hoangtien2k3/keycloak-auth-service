package com.hoangtien2k3.authmodel.dto.request;

import com.hoangtien2k3.authmodel.dto.response.IndividualDTO;
import com.hoangtien2k3.authmodel.model.TenantIdentify;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrganizationRequest extends OrganizationRequest {
    @Valid
    private IndividualDTO representative;

    @Valid
    private List<TenantIdentify> identifies;
}
