package com.apec.pos.Dto.ToppingDTO;

import com.apec.pos.dto.ToppingDTO.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToppingResponse {
    private Integer id;
    private String name;
    private List<Item> itemList;
}
