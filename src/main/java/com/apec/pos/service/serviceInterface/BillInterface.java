package com.apec.pos.service.serviceInterface;

import com.apec.pos.dto.billDTO.BillRequest;
import com.apec.pos.dto.billDTO.BillResponse;
import com.apec.pos.dto.billDTO.BillResponsePage;
import com.apec.pos.entity.BillEntity;
import com.apec.pos.enu.OrderStatus;

import java.util.List;

public interface BillInterface {
    public BillEntity addBill(BillRequest billRequest);

    public BillEntity updateBill(OrderStatus orderStatus, Integer id);

    public BillResponsePage getBill(int pageIndex, int pageSize, OrderStatus orderStatus);

    public BillResponsePage getBillUser(int pageIndex, int pageSize, OrderStatus orderStatus);
}
