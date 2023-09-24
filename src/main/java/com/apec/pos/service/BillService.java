package com.apec.pos.service;


import com.apec.pos.dto.FoodDto.BillFoodRequest;
import com.apec.pos.dto.ToppingDTO.Item;
import com.apec.pos.dto.billDTO.BillRequest;
import com.apec.pos.dto.billDTO.BillResponse;
import com.apec.pos.dto.billDTO.FoodResponseBill;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.BillDetailEntity;
import com.apec.pos.entity.BillEntity;
import com.apec.pos.entity.FoodEntity;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.repository.BillRepository;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.serviceInterface.BillInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twilio.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    BillRepository getRepository() {
        // TODO Auto-generated method stub
        return billRepository;
    }

    @Override
    public BillEntity addBill(BillRequest billRequest) {

        Gson gson = new Gson();

        BillEntity result = BillEntity.builder()
                .orderStatus(OrderStatus.PENDING)
                .totalAmount(billRequest.getTotalAmount())
                .orderBy(PosApplication.currentUserGlobal)
                .nameRes(billRequest.getNameRes())
                .build()
                ;
        result = billRepository.insert(result);
        List<BillDetailEntity> billDetailEntities = new ArrayList<>();
        for (BillFoodRequest x: billRequest.getBillFoodRequests()
        ) {
            BillDetailEntity temp = BillDetailEntity.builder()
                    .billEntityId(result.getId())
                    .foodEntityId(x.getFoodId())
                    .quantity(x.getQuantity())
                    .item(gson.toJson(x.getItemList()))
                    .build();
            billDetailEntities.add(temp);
        }
        result.setBillDetailEntities(billDetailEntities);
        return billRepository.update(result);
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

    @Override
    public List<BillResponse> getBill(int pageIndex, int pageSize, OrderStatus orderStatus) {
        Gson gson = new Gson();
        //tao pageRequest
        PageRequest pageRequest = PageRequest.of(pageIndex,pageSize);

        List<BillEntity> billEntities = billRepository.pagingBill(pageRequest,orderStatus);
        List<BillResponse> result = new ArrayList<>();
        for (BillEntity x:billEntities
              ) {
            //tao LIST FOOD CHO TRA VE CHO BILL
            List<FoodResponseBill> foodResponseBills = new ArrayList<>();
            List<BillDetailEntity> billDetailEntities = x.getBillDetailEntities();
            for (BillDetailEntity y:billDetailEntities
                 ) {
                //tim food
                FoodEntity foodEntity = y.getFoodEntity();
                if (foodEntity==null){
                    break;
                }
                FoodResponseBill foodResponseBill = FoodResponseBill.builder()
                        .foodId(y.getFoodEntityId())
                        .nameRes(foodEntity.getRestaurantEntity().getRestaurantName())
                        .resId(foodEntity.getRestaurantEntityId())
                        .quantity(y.getQuantity())
                        .nameFood(foodEntity.getFoodName())
                        .priceFood(foodEntity.getPrice())
                        .itemList(gson.fromJson(y.getItem(),new TypeToken<List<Item>>(){}.getType()))
                        .build();
                foodResponseBills.add(foodResponseBill);
            }
            // tao BillRespone de tra ve
            BillResponse billResponse = BillResponse.builder()
                    .createAt(x.getCreateDate())
                    .nameRestaurant(x.getNameRes())
                    .orderStatus(x.getOrderStatus())
                    .foodResponseBills(foodResponseBills)
                    .finishTime(x.getFinishTime())
                    .shipFee(x.getShipFee())
                    .id(x.getId())
                    .build();
            result.add(billResponse);
        }
        return result;
    }

    @Override
    public List<BillResponse> getBillUser(int pageIndex, int pageSize, OrderStatus orderStatus) {
        //tao pageRequest
        PageRequest pageRequest = PageRequest.of(pageIndex,pageSize);

        Gson gson = new Gson();

        //tim user hien tai
        AccountEntity accountEntity = accountRepository.findByUsername(PosApplication.currentUserGlobal);

        List<BillEntity> billEntities = billRepository.pagingUserBill(pageRequest,orderStatus,accountEntity.getId());
        List<BillResponse> result = new ArrayList<>();
        for (BillEntity x:billEntities
        ) {
            //tao LIST FOOD CHO TRA VE CHO BILL
            List<FoodResponseBill> foodResponseBills = new ArrayList<>();
            List<BillDetailEntity> billDetailEntities = x.getBillDetailEntities();
            for (BillDetailEntity y:billDetailEntities
            ) {
                //tim food
                FoodEntity foodEntity = y.getFoodEntity();
                if (foodEntity==null){
                    break;
                }
                FoodResponseBill foodResponseBill = FoodResponseBill.builder()
                        .foodId(y.getFoodEntityId())
                        .nameRes(foodEntity.getRestaurantEntity().getRestaurantName())
                        .resId(foodEntity.getRestaurantEntityId())
                        .quantity(y.getQuantity())
                        .nameFood(foodEntity.getFoodName())
                        .priceFood(foodEntity.getPrice())
                        .itemList(gson.fromJson(y.getItem(),new TypeToken<List<Item>>(){}.getType()))
                        .build();
                foodResponseBills.add(foodResponseBill);
            }
            // tao BillRespone de tra ve
            BillResponse billResponse = BillResponse.builder()
                    .createAt(x.getCreateDate())
                    .nameRestaurant(x.getNameRes())
                    .orderStatus(x.getOrderStatus())
                    .foodResponseBills(foodResponseBills)
                    .finishTime(x.getFinishTime())
                    .shipFee(x.getShipFee())
                    .id(x.getId())
                    .build();
            result.add(billResponse);
        }
        return result;
    }
}
