package com.hoangtien2k3.authservice.service;

import com.hoangtien2k3.authmodel.dto.request.ActionLogRequest;
import com.hoangtien2k3.authmodel.dto.response.SearchActionLogResponse;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

public interface ActionLogService {

    /**
     * Function : Get action log list of user
     *
     * @param request
     *            : search params
     * @return
     */
    Mono<SearchActionLogResponse> search(ActionLogRequest request);

    /**
     * Function : Get excel file
     *
     * @param request
     *            : search params
     * @return
     */
    Mono<Resource> exportUser(ActionLogRequest request);
}
