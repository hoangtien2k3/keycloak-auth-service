package com.hoangtien2k3.notiservice.repository.query

interface NotificationCategoryQuery {
    companion object {
        const val findCategoryIdByType = "SELECT nc.id FROM notification_category nc WHERE nc.type = :categoryType AND status = 1"
    }
}
