package com.hoangtien2k3.authmodel.dto.response;

import com.hoangtien2k3.authmodel.dto.PaginationDTO;
import com.hoangtien2k3.authmodel.model.ActionLog;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchActionLogResponse {
    private List<ActionLog> actionLogs;
    private PaginationDTO pagination;
}
