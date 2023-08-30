package com.apec.pos.service.serviceInterface;

import com.apec.pos.entity.FoodEntity;

import java.util.List;

public interface CartInterface {
    public List<FoodEntity> addToCart(List<Integer> ids);
}
