package com.apec.pos.dto.billDTO;

import com.apec.pos.dto.FoodDto.BillFoodRequest;
import com.apec.pos.enu.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {
    private OrderStatus orderStatus;
    private long totalAmount;
    private String nameRes;
    private List<BillFoodRequest> billFoodRequests;

}
