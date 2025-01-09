package com.hoangtien2k3.authservice.repotemplate;

import com.hoangtien2k3.authmodel.dto.request.ActionLogRequest;
import com.hoangtien2k3.authmodel.model.ActionLog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActionLogRepositoryTemplate {
    /**
     * Function : Get action log list of user
     *
     * @param request
     *            : search params
     * @return
     */
    Flux<ActionLog> search(ActionLogRequest request);

    /**
     * Function : Get record total
     *
     * @param request
     *            : search params
     * @return
     */
    Mono<Long> count(ActionLogRequest request);
}
