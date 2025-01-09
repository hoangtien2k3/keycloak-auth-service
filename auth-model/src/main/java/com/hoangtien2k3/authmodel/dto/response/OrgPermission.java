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
public class OrgPermission {
    private String idNo;

    private List<Permission> permissions;
}
