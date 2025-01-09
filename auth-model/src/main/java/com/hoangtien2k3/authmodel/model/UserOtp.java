package com.hoangtien2k3.authmodel.model;

import com.hoangtien2k3.authmodel.model.base.EntityBase;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_otp")
@SuperBuilder
public class UserOtp extends EntityBase implements Persistable<String> {
    @Id
    @Column("id")
    private String id;

    @Column("type")
    private String type;

    @Column("email")
    private String email;

    @Column("otp")
    private String otp;

    @Column("exp_time")
    private LocalDateTime expTime;

    @Column("tries")
    private Integer tries;

    @Column("status")
    private Integer status;

    @Transient
    private boolean newOtp;

    @Transient
    @Override
    public boolean isNew() {
        return this.newOtp || id == null;
    }

    public UserOtp setAsNew() {
        this.newOtp = true;
        return this;
    }
}
