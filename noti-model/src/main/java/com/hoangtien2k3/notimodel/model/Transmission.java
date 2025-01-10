package com.hoangtien2k3.notimodel.model;

import com.hoangtien2k3.notimodel.model.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

@ToString
@Table(name = "transmission")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transmission extends EntityBase {
    private String id;
    private String notificationId;
    private String receiver;
    private String email;
    private String channelId;
    private String state;
    private Integer status;
    private int resendCount;

    public void inreaseResendCount() {
        resendCount++;
    }
}
