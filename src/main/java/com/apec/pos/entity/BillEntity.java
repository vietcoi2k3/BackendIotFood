package com.apec.pos.entity;


import com.apec.pos.enu.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillEntity extends BaseEntity{
    private Date finishDate;
    private OrderStatus orderStatus;
    private long totalAmount;
    private String orderBy;

    @OneToMany(mappedBy = "")
    @JsonManagedReference("bill-food")
    private List<FoodEntity> foodEntities;

}
