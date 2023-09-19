package com.apec.pos.dto.TypeDto;

import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailTypeFood {
    private Date createAt;
    private boolean status;
    private String nameType;
    private String imgType;
    private List<FoodRecommendDto> foodRecommendDtos;
}
