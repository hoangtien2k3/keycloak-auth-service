package com.hoangtien2k3.authservice.repository;

import com.hoangtien2k3.authmodel.model.PermissionPolicy;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IndOrgPermissionRepo extends R2dbcRepository<PermissionPolicy, String> {
    @Query(
            value = "select pp.id as id, pp.type as type, pp.policy_id as policy_id\n"
                    + "from individual_organization_permissions iop\n" + "         left join permission_policy pp\n"
                    + "                   on iop.id = pp.individual_organization_permissions_id\n"
                    + "         join individual i on i.id = iop.individual_id\n"
                    + "where iop.organization_id = :orgId\n"
                    + "  and i.user_id = :userId\n" + "  and iop.status = 1\n" + "  and pp.status = 1\n"
                    + "  and i.status = 1")
    Flux<PermissionPolicy> getAllByUserId(String orgId, String userId);

    @Query(
            value = "select count(distinct (iop.organization_id))\n" + "from individual_organization_permissions iop\n"
                    + "         inner join individual i on i.id = iop.individual_id\n" + "where i.status = 1\n"
                    + "  and iop.status = 1\n" + "  and i.user_id = :userId")
    Mono<Integer> getOrgIds(String userId);
}
