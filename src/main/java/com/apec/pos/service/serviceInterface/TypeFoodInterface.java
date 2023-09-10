package com.apec.pos.service.serviceInterface;

import java.util.List;

import java.util.Set;

import com.apec.pos.dto.TypeDto.TypefoodResponseData;
import com.apec.pos.dto.TypeDto.UpdateTypeRequest;
import com.apec.pos.dto.restaurantDto.SearchForm;

public interface TypeFoodInterface {
    public TypefoodResponseData addTypeFood(UpdateTypeRequest updateTypeRequest);

    public TypefoodResponseData updateTypeFood(UpdateTypeRequest updateTypeRequest);

    public TypefoodResponseData updateStatusType(Integer id, Boolean status);

    public String deleteType(Integer id);

    public Set<Integer> MultiDelete(Set<Integer> ids);

    public List<SearchForm> searchType(String key);

}
