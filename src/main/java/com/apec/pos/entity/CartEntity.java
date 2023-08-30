package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity extends  BaseEntity{

    @OneToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<FoodEntity> foodEntities;

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
