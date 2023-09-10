package com.apec.pos.Dto.ToppingDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToppingResponse {
    private Integer id;
    private Integer foodId;
    private String name;
    private Integer price;
}
