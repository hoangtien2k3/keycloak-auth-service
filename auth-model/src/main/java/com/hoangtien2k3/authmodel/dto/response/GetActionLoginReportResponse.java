package com.hoangtien2k3.authmodel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetActionLoginReportResponse {
    private Integer loginCount; // so luong login
}
