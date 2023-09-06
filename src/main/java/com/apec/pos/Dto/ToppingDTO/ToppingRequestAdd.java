package com.apec.pos.Dto.ToppingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToppingRequestAdd {
    private String name;
    private Integer price;

}
