package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.model.Individual;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface IndividualRepository extends R2dbcRepository<Individual, String> {
    @Query(value = "select * from individual where username = :username")
    Mono<Individual> findByUsername(String username);
}
