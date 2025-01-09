package com.hoangtien2k3.authmodel.dto.response;

import com.hoangtien2k3.authmodel.dto.PaginationDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchPermissionPolicyResponse {
    private List<PermissionPolicyDetailDto> content;
    private PaginationDTO pagination;
}
