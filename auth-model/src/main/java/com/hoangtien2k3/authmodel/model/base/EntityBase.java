package com.hoangtien2k3.authmodel.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.relational.core.mapping.Column;

@Data
// @MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EntityBase implements Serializable {
    @Column("create_at")
    private LocalDateTime createAt;

    @Column("create_by")
    @Length(max = 255, message = "createBy.over.length")
    private String createBy;

    @Column("update_at")
    @Length(max = 255, message = "updateBy.over.length")
    private LocalDateTime updateAt;

    @Column("update_by")
    private String updateBy;
}
