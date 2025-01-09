package com.hoangtien2k3.authmodel.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgPermissionResp {
    private String idNo;
    private String orgId;
    private List<Permission> permissions;
}
