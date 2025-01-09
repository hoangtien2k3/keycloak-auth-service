package com.hoangtien2k3.authservice.service;

import com.hoangtien2k3.authmodel.dto.request.JobAddRoleAdminForOldUserRequest;
import com.reactify.model.response.DataResponse;
import reactor.core.publisher.Mono;

/**
 * Interface for utility services in the application.
 */
public interface UtilService {
    Mono<DataResponse<Object>> jobAddRoleAdminForOldUser(JobAddRoleAdminForOldUserRequest request);
}
