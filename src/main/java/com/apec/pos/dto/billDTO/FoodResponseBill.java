package com.apec.pos.dto.billDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseBill {
    private Integer foodId;
    private String nameFood;
    private Integer priceFood;
    private Integer quantity;
}
