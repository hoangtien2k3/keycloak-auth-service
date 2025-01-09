package com.hoangtien2k3.authservice.controller;

import com.hoangtien2k3.authmodel.constants.UrlPaths;
import com.hoangtien2k3.authmodel.dto.request.JobAddRoleAdminForOldUserRequest;
import com.hoangtien2k3.authservice.service.UtilService;
import com.reactify.model.response.DataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlPaths.Util.PREFIX)
public class UtilController {

    private final UtilService utilService;

    /**
     * add role admin for old user
     * @param request
     * @return
     */
    @PostMapping(value = UrlPaths.Util.JOB_ADD_ROLE_ADMIN_FOR_OLD_USER)
    @PreAuthorize("hasAnyAuthority('system')")
    public Mono<ResponseEntity<DataResponse>> jobAddRoleAdminForOldUser(@Valid @RequestBody JobAddRoleAdminForOldUserRequest request) {
        return utilService.jobAddRoleAdminForOldUser(request)
                .map(rs -> ResponseEntity.ok(new DataResponse("common.success", rs.getData())));
    }

}
