package com.apec.pos.repository;

import com.apec.pos.entity.CartEntity;
import org.springframework.stereotype.Repository;

//@Repository
public class CartRepository extends BaseRepository<CartEntity,Integer>{

    public CartRepository() {
        super(CartEntity.class);
    }

}
