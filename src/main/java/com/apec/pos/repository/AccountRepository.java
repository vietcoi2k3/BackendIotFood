package com.apec.pos.repository;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.FoodEntity;

import jakarta.persistence.EntityManager;


@Repository
//@CacheConfig(cacheNames = "iotFood")
public class AccountRepository extends BaseRepository<AccountEntity, Integer> {

    @Autowired
    private EntityManager entityManager;

    public AccountRepository() {
        super(AccountEntity.class);
        // TODO Auto-generated constructor stub
    }

    public List<AccountEntity> paging(PageRequest pageRequest) {
        String query = "SELECT c FROM AccountEntity c";
        Map<String, Object> params = new HashMap<>();
        return query(query, false, params, pageRequest);
    }

    public AccountEntity findByUsername(String username) {
        System.out.println("đã gọi");
        String query = "FROM AccountEntity c WHERE c.username = :username";
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        List<AccountEntity> result = query(query, false, params);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    private String buildQuery(AccountEntity accountEntity) {
        String query = "FROM AccountEntity c WHERE 1=1 ";


        if (accountEntity.getId() > 0) {
            query += " AND c.id = :id";
        }

        if (Strings.isNotBlank(accountEntity.getUsername())) {
            query += " AND c.username = :username";
        }

        if (Strings.isNotBlank(accountEntity.getPassword())) {
            query += " AND c.username = :password";
        }


        return query;
    }

    public Map<String, Object> getParams(AccountEntity accountEntity) {
        Map<String, Object> params = new HashMap<>();
        if (accountEntity.getId() > 0) {
            params.put("id", accountEntity.getId());
        }

        if (Strings.isNotBlank(accountEntity.getUsername())) {
            params.put("username", accountEntity.getUsername());
        }

        if (Strings.isNotBlank(accountEntity.getPassword())) {
            params.put("password", accountEntity.getPassword());
        }

        return params;
    }


}
