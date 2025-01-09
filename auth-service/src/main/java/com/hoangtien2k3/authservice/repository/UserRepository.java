package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.model.UserProfile;
import java.time.LocalDateTime;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<UserProfile, String>, UserRepositoryTemplate {
    @Query(value = "select * from user_profile where user_id = :id")
    Mono<UserProfile> findById(String id);

    @Query(value = "Select now()")
    Mono<LocalDateTime> currentTimeDb();
}
