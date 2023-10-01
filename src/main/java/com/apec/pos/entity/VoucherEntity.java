package com.apec.pos.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoucherEntity extends BaseEntity{
    private String discount;
    private LocalDate expired;
    private String detail;
    private String idVoucher;

}
