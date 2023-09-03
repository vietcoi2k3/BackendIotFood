package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToppingEntity extends BaseEntity {
    private String name;
    private Integer price;

    @Column(name = "foodEntityId")
    private Integer foodEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodEntityId", updatable = false, insertable = false)
    @JsonBackReference(value = "food-top")
    private FoodEntity foodEntity;


}
