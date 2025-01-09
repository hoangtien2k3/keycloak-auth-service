package com.hoangtien2k3.notificationmodel.dto.response;

import com.hoangtien2k3.notificationmodel.model.NotificationContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class NotificationHeader extends NotificationContent {
    private String state;

    public NotificationHeader(
            String id,
            String title,
            String subTitle,
            String imageUrl,
            String url,
            Integer status,
            String state,
            String externalData) {
        super(id, title, subTitle, imageUrl, url, status, externalData);
        this.state = state;
    }
}
