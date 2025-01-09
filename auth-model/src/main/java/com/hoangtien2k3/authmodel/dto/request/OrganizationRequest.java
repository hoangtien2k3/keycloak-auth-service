package com.hoangtien2k3.authmodel.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationRequest {
    @Length(max = 255, message = "organization.name.over.length")
    @NotEmpty(message = "organization.name.not.empty")
    private String name;

    @Length(max = 5, message = "organization.provinceCode.over.length")
    @NotEmpty(message = "organization.provinceCode.not.empty")
    private String provinceCode;

    @Length(max = 5, message = "organization.districtCode.over.length")
    @NotEmpty(message = "organization.districtCode.not.empty")
    private String districtCode;

    @Length(max = 5, message = "organization.precinctCode.over.length")
    @NotEmpty(message = "organization.precinctCode.not.empty")
    private String precinctCode;

    @Length(max = 12, message = "organization.phone.over.length")
    @NotEmpty(message = "organization.phone.not.empty")
    private String phone;

    private LocalDateTime foundingDate;

    @Length(max = 255, message = "organization.businessType.over.length")
    private String businessType;

    @Length(max = 500, message = "organization.image.over.length")
    private String image;

    @Length(max = 200, message = "organization.streetBlock.over.length")
    @NotEmpty(message = "organization.streetBlock.not.empty")
    private String streetBlock;

    @Length(max = 50, message = "organization.email.over.length")
    @NotEmpty(message = "organization.email.not.empty")
    private String email;

    @Max(value = 99, message = "organization.state.over.length")
    private Integer state;

    @Length(max = 50, message = "organization.type.over.length")
    private String orgType; // loai khach hang

    private String taxDepartment;
}
