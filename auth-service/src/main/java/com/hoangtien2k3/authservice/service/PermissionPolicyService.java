package com.hoangtien2k3.authservice.service;

import com.hoangtien2k3.authmodel.dto.request.CreateIndPermistionRequest;
import com.hoangtien2k3.authmodel.dto.response.PermissionPolicyDetailDto;
import com.hoangtien2k3.authmodel.model.IndividualOrganizationPermissions;
import com.hoangtien2k3.authmodel.model.PermissionPolicy;
import com.reactify.model.TokenUser;
import com.reactify.model.response.DataResponse;
import java.time.LocalDateTime;
import java.util.UUID;
import reactor.core.publisher.Mono;

public interface PermissionPolicyService {
    Mono<DataResponse> getPermissionPolicyDto(
            String filter, Integer state, Integer pageIndex, Integer pageSize, String sort);

    Mono<DataResponse<Boolean>> deletePermissionPolicy(String permissionPolicyId);

    Mono<DataResponse<Boolean>> addOrUpdatePermissionPolicy(CreateIndPermistionRequest request);

    Mono<DataResponse<PermissionPolicyDetailDto>> getTelecomServiceByOrg(UUID organizationId);

    Mono<PermissionPolicy> createPermissionPolicy(
            String type,
            String keycloakId,
            String keycloakName,
            String policyId,
            IndividualOrganizationPermissions individualOrganizationPermissions,
            LocalDateTime now,
            TokenUser currentUser);
}
