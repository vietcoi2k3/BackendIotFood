package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.billDTO.BillRequest;
import com.apec.pos.entity.BillEntity;
import com.apec.pos.enu.OrderStatus;

public interface BillInterface {
    public BillEntity addBill(BillRequest billRequest);
    public BillEntity updateBill(OrderStatus orderStatus,Integer id);
}
