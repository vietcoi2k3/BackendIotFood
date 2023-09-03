package com.apec.pos.Dto.FoodDto;

import com.apec.pos.Dto.ToppingDTO.ToppingRequest;
import com.apec.pos.entity.ToppingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


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
}
