package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.model.Organization;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface OrganizationRepo extends R2dbcRepository<Organization, String> {
    @Query(
            value = "select id from organization\n" + "where id in ( \n"
                    + "    select tenant_id from tenant_identify where type =:type\n"
                    + "    and status = 1 and trust_status = 1 and id_no =:idNo\n" + ");")
    Mono<String> findOrganizationByIdentify(String type, String idNo);
}
