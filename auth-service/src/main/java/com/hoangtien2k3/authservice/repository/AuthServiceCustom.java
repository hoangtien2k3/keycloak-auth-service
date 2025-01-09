package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.dto.response.PermissionPolicyDetailDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthServiceCustom {
    Mono<Integer> countPermissionPolicyDetail(String filter, Integer state, String sort);

    Flux<PermissionPolicyDetailDto> getPermissionPolicyDetail(
            String filter, Integer state, Integer offset, Integer pageSize, String sort);
}
