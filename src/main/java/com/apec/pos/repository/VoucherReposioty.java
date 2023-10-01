package com.apec.pos.repository;

import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.entity.VoucherEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VoucherReposioty extends BaseRepository<VoucherEntity,Integer>{
    public VoucherReposioty() {
        super(VoucherEntity.class);
    }

    public List<VoucherEntity> paging(PageRequest pageRequest) {
        String query = "SELECT c FROM VoucherEntity c";
        Map<String, Object> params = new HashMap<>();
        return query(query, false, params, pageRequest);
    }
}
