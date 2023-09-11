package com.apec.pos.service;


import com.apec.pos.dto.FoodDto.BillFoodRequest;
import com.apec.pos.dto.billDTO.BillRequest;
import com.apec.pos.entity.BillDetailEntity;
import com.apec.pos.entity.BillEntity;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.repository.BillRepository;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.serviceInterface.BillInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.PosApplication;

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

        List<BillDetailEntity> billDetailEntities = new ArrayList<>();
        for (BillFoodRequest x: billRequest.getBillFoodRequests()
             ) {
            BillDetailEntity temp = BillDetailEntity.builder()
                    .billEntityId((int)( billRepository.countAll())+1)
                    .foodEntityId(x.getFoodId())
                    .quantity(x.getQuantity())
                    .build();
            billDetailEntities.add(temp);
        }

        BillEntity result = BillEntity.builder()
                .orderStatus(OrderStatus.PENDING)
                .totalAmount(billRequest.getTotalAmount())
                .orderBy(PosApplication.currentUserGlobal)
                .billDetailEntities(billDetailEntities)
                .build()
                ;



        return billRepository.insert(result);
    }

    @Override
    public BillEntity updateBill(OrderStatus orderStatus, Integer id) {
        BillEntity billEntity = billRepository.findOne(id);
        if (orderStatus == OrderStatus.DELIVERED) {
            billEntity.setOrderStatus(orderStatus);
            billEntity.setFinishDate(new Date());
        } else {
            billEntity.setOrderStatus(orderStatus);
        }

        return billRepository.insert(billEntity);
    }
}
