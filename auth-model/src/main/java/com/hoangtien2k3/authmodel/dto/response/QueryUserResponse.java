package com.hoangtien2k3.authmodel.dto.response;

import com.hoangtien2k3.authmodel.dto.PaginationDTO;
import com.hoangtien2k3.authmodel.dto.UserProfileDTO;
import java.util.List;
import lombok.Data;

@Data
public class QueryUserResponse {

    private List<UserProfileDTO> content;
    private PaginationDTO pagination;
}
