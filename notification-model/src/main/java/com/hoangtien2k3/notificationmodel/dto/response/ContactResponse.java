package com.hoangtien2k3.notificationmodel.dto.response;

import com.hoangtien2k3.notificationmodel.dto.ContactInfoDTO;
import java.util.List;
import lombok.Data;

@Data
public class ContactResponse {
    private String errorCode;
    private String message;
    private List<ContactInfoDTO> data;
}
