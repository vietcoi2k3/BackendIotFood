package com.apec.pos.dto.FoodDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillFoodRequest {
    private Integer foodId;
    private Integer quantity;
}
