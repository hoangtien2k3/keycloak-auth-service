package com.hoangtien2k3.notificationservice.repository.query

interface ChannelQuery {
    companion object {
        const val findChannelIdByType = "SELECT id FROM channel WHERE type = :channelType AND status = 1"
    }
}
