package com.hoangtien2k3.notiservice.repository

import com.hoangtien2k3.notiservice.repository.query.ChannelQuery
import com.hoangtien2k3.notimodel.model.Channel
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.r2dbc.repository.Query
import reactor.core.publisher.Mono

interface ChannelRepository : R2dbcRepository<Channel, String> {

    override fun findById(id: String): Mono<Channel>

    @Query(ChannelQuery.findChannelIdByType)
    fun findChannelIdByType(channelType: String): Mono<String>
}
