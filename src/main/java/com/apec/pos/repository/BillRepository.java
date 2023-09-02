package com.apec.pos.repository;

import com.apec.pos.entity.BaseEntity;
import com.apec.pos.entity.BillEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BillRepository extends BaseRepository<BillEntity,Integer>{



    public BillRepository( ) {
        super(BillEntity.class);
    }
}
