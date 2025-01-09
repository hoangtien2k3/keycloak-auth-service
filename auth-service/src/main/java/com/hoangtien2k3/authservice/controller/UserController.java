package com.hoangtien2k3.authservice.controller;

import com.hoangtien2k3.authmodel.constants.UrlPaths;
import com.hoangtien2k3.authmodel.dto.request.QueryUserRequest;
import com.hoangtien2k3.authmodel.dto.request.UpdateUserRequest;
import com.hoangtien2k3.authmodel.model.UserProfile;
import com.hoangtien2k3.authservice.service.UserService;
import com.reactify.constants.MessageConstant;
import com.reactify.model.response.DataResponse;
import com.reactify.util.Translator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlPaths.User.PREFIX)
public class UserController {
    private final UserService userService;

    @GetMapping(UrlPaths.User.GET_USER)
    @PreAuthorize("hasAnyAuthority('user')")
    public Mono<ResponseEntity<DataResponse>> getUser() {
        return userService.getUserProfile()
                .map(rs -> ResponseEntity.ok(new DataResponse<>(MessageConstant.SUCCESS,
                        rs)));
    }

    @PostMapping(UrlPaths.User.UPDATE_USER)
    @PreAuthorize("hasAnyAuthority('user')")
    public Mono<DataResponse<UserProfile>> updateUser(@Valid @RequestBody UpdateUserRequest user) {
        return userService.update(user)
                .map(rs -> new DataResponse<>(Translator.toLocaleVi("user.update.success"),
                        rs));
    }

    @GetMapping(UrlPaths.User.CONTACTS)
    @PreAuthorize("hasAnyAuthority('system')")
    public Mono<ResponseEntity<DataResponse>> getUserContacts(@RequestBody List<UUID> ids) {
        return userService.getUserContacts(ids).collectList()
                .map(rs -> ResponseEntity.ok(new
                        DataResponse<>(Translator.toLocaleVi("success"), rs)));
    }

    @GetMapping(UrlPaths.User.GET_USER_BY_ID)
    @PreAuthorize("hasAnyAuthority('system')")
    public Mono<ResponseEntity<DataResponse>> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(rs -> ResponseEntity.ok(new DataResponse<>(MessageConstant.SUCCESS,
                        rs)));
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping(UrlPaths.User.USER_PROFILES)
    public Mono<ResponseEntity<DataResponse>> getUserProfiles(QueryUserRequest request) {
        return userService.queryUserProfile(request)
                .map(rs -> ResponseEntity.ok(new DataResponse(MessageConstant.SUCCESS, rs)));
    }

    @GetMapping(UrlPaths.User.GET_PROFILES)
    public Mono<ResponseEntity<DataResponse>> getUserProfile(@PathVariable("id") String userId) {
        return userService.getUserProfile(userId)
                .map(rs -> ResponseEntity.ok(new DataResponse(MessageConstant.SUCCESS, rs)));
    }

    @GetMapping(UrlPaths.User.KEYCLOAK)
    @PreAuthorize("hasAnyAuthority('system', 'admin')")
    public Mono<String> getEmailByKeycloakUsername(@RequestParam String username) {
        return userService.getEmailsByKeycloakUsername(username).map(UserRepresentation::getEmail);
    }
}
