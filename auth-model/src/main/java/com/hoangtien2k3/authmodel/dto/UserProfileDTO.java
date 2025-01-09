package com.hoangtien2k3.authmodel.dto;

import com.hoangtien2k3.authmodel.model.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileDTO extends UserProfile {
    private String name;
}
