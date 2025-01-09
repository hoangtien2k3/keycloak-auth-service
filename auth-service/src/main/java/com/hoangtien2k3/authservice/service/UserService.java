package com.hoangtien2k3.authservice.service;

import com.hoangtien2k3.authmodel.dto.UserProfileDTO;
import com.hoangtien2k3.authmodel.dto.request.QueryUserRequest;
import com.hoangtien2k3.authmodel.dto.request.UpdateUserRequest;
import com.hoangtien2k3.authmodel.dto.response.*;
import com.hoangtien2k3.authmodel.model.UserProfile;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.keycloak.representations.idm.UserRepresentation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<Optional<UserProfile>> getUserProfile();

    Mono<UserProfile> update(UpdateUserRequest u);

    Flux<UserContact> getUserContacts(List<UUID> userIds);

    Mono<Optional<UserProfile>> getUserById(String id);

    Mono<QueryUserResponse> queryUserProfile(QueryUserRequest request);

    Mono<UserProfileDTO> getUserProfile(String id);

    Mono<UserRepresentation> getEmailsByKeycloakUsername(String username);
}
