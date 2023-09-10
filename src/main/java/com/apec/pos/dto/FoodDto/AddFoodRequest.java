package com.apec.pos.dto.FoodDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFoodRequest implements Serializable {

    private Integer id;
    private String foodName;
    private Integer price;
    private String detail;
    private MultipartFile imgFood;
    private Integer typeFoodEntityId;
    private Integer restaurantEntityId;
    private String toppingRequest;
}
