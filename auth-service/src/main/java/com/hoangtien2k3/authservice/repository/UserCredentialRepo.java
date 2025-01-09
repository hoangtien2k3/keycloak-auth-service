package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.model.UserCredential;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface UserCredentialRepo extends R2dbcRepository<UserCredential, String> {
    @Query(value = "select * from user_credential " + "where username = :username and status = :status")
    Flux<UserCredential> getUserCredentialByUserName(String username, Integer status);
}
