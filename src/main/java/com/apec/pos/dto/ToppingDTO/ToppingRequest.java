package com.apec.pos.dto.ToppingDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToppingRequest implements Serializable {
    private Integer id;
    private String name;
    private Integer price;
    private Integer foodId;
}
