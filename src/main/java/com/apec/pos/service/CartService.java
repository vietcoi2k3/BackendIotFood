package com.apec.pos.service;

import com.apec.pos.entity.CartEntity;
import com.apec.pos.entity.FoodEntity;
import com.apec.pos.repository.CartRepository;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.serviceInterface.CartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class CartService extends BaseService<CartRepository, CartEntity,Integer> implements CartInterface {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    CartRepository getRepository() {
        return cartRepository;
    }

    @Override
    public List<FoodEntity> addToCart(List<Integer> ids) {
        for (Integer x: ids
             ) {
            FoodEntity temp = foodRepository.findOne(x);
        }
        return null;
    }
}
