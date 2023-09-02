package com.apec.pos.service;

import com.apec.pos.Dto.billDTO.BillRequest;
import com.apec.pos.PosApplication;
import com.apec.pos.entity.BillEntity;
import com.apec.pos.entity.FoodEntity;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.repository.BillRepository;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.BaseService;
import com.apec.pos.service.serviceInterface.BillInterface;
import io.swagger.models.auth.In;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillService extends BaseService<BillRepository, BillEntity, Integer> implements BillInterface {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    BillRepository getRepository() {
        // TODO Auto-generated method stub
        return billRepository;
    }

    @Override
    public BillEntity addBill(BillRequest billRequest) {

        List<FoodEntity> foodEntities=new ArrayList<>();
        for (Integer x:billRequest.getIdFoods()
             ) {
            foodEntities.add(foodRepository.findOne(x));
        }

        BillEntity billEntity= BillEntity.builder()
                .orderBy(PosApplication.currentUserGlobal)
                .orderStatus(billRequest.getOrderStatus())
                .totalAmount(billRequest.getTotalAmount())
                .foodEntities(foodEntities).build();

        return billRepository.insert(billEntity);
    }

    @Override
    public BillEntity updateBill(OrderStatus orderStatus,Integer id) {
        BillEntity billEntity = billRepository.findOne(id);
        if (orderStatus==OrderStatus.DELIVERED)
        {
            billEntity.setOrderStatus(orderStatus);
            billEntity.setFinishDate(new Date());
        }
        else {
            billEntity.setOrderStatus(orderStatus);
        }

        return billRepository.insert(billEntity);
    }
}
