package com.hoangtien2k3.authmodel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaginationDTO {
    private Long totalRecords;
    private Integer pageIndex;
    private Integer pageSize;
}
