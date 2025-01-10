package com.hoangtien2k3.notiservice.repository.query

interface NotificationContentQuery {
    companion object {
        const val insertNotificationContent = """
            INSERT INTO notification_content (id, title, sub_title, image_url, create_at, create_by, update_at, update_by, url, status)
            VALUES (:id, :title, :subTitle, :imageUrl, :createAt, :createBy, :updateAt, :updateBy, :url, :status);
        """
    }
}
