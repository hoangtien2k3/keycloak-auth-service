package com.hoangtien2k3.authservice.controller;

import com.hoangtien2k3.authmodel.constants.UrlPaths;
import com.hoangtien2k3.authmodel.dto.request.ActionLogRequest;
import com.hoangtien2k3.authservice.service.ActionLogService;
import com.reactify.model.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlPaths.ActionLog.PREFIX)
public class ActionLogController {

    private final ActionLogService actionLogService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('admin')")
    public Mono<ResponseEntity<DataResponse<?>>> search(ActionLogRequest request) {
        return actionLogService
                .search(request)
                .flatMap(rs -> Mono.just(ResponseEntity.ok(new DataResponse<>("common.success", rs))));
    }

    @GetMapping("/excel")
    public Mono<ResponseEntity<Resource>> getExportFile(ActionLogRequest request) {
        return actionLogService.exportUser(request).map(resource -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
                .body(resource));
    }
}
