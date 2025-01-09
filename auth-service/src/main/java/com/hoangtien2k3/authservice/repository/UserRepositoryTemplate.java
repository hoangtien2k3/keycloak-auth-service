package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.dto.UserProfileDTO;
import com.hoangtien2k3.authmodel.dto.request.QueryUserRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepositoryTemplate {
    Flux<UserProfileDTO> queryUserProfile(QueryUserRequest request);

    Mono<Long> countUserProfile(QueryUserRequest request);
}
