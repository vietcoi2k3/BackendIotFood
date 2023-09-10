package com.apec.pos.service.serviceInterface;


import com.apec.pos.Dto.ToppingDTO.ToppingResponse;
import com.apec.pos.dto.ToppingDTO.ToppingRequest;
import io.swagger.models.auth.In;

import java.util.Set;

public interface ToppingInterface {
    public ToppingResponse addTopping(ToppingRequest toppingRequest);

    public ToppingResponse updateTopping(ToppingRequest toppingRequest);

    public void deleteTopping(Set<Integer> ids);
}
