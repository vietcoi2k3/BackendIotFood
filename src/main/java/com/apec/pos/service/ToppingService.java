package com.apec.pos.service;

import com.apec.pos.Dto.ToppingDTO.ToppingRequest;
import com.apec.pos.Dto.ToppingDTO.ToppingResponse;
import com.apec.pos.entity.ToppingEntity;
import com.apec.pos.repository.ToppingRepository;
import com.apec.pos.service.serviceInterface.ToppingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ToppingService extends  BaseService<ToppingRepository, ToppingEntity,Integer>  implements ToppingInterface {

    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    ToppingRepository getRepository() {
        return toppingRepository;
    }

    @Override
    public ToppingResponse addTopping(ToppingRequest toppingRequest) {
        ToppingEntity toppingEntity = ToppingEntity.builder()
                .foodEntityId(toppingRequest.getFoodId())
                .name(toppingRequest.getName())
                .price(toppingRequest.getPrice())
                .build();
        System.out.println(toppingEntity.getName());
        toppingEntity = toppingRepository.insert(toppingEntity);

        ToppingResponse toppingResponse = ToppingResponse.builder()
                .id(toppingEntity.getFoodEntityId())
                .name(toppingEntity.getName())
                .price(toppingEntity.getPrice())
                .foodId(toppingEntity.getFoodEntityId())
                .build();
        return toppingResponse;
    }

    @Override
    public ToppingResponse updateTopping(ToppingRequest toppingRequest) {
        ToppingEntity toppingEntity = toppingRepository.findOne(toppingRequest.getId());
        toppingEntity =ToppingEntity.builder()
                .price(toppingRequest.getPrice()!=null ? toppingRequest.getPrice() : toppingEntity.getPrice())
                .name(toppingRequest.getName() !=null ? toppingRequest.getName() : toppingEntity.getName())
                .build();
        toppingRepository.update(toppingEntity);

        ToppingResponse toppingResponse = ToppingResponse.builder()
                .price(toppingEntity.getPrice())
                .name(toppingEntity.getName())
                .foodId(toppingEntity.getFoodEntityId())
                .id(toppingEntity.getId())
                .build();
        return null;
    }

    @Override
    public void deleteTopping(Set<Integer> ids) {
        for (Integer x:ids
             ) {
            toppingRepository.delete(x);
        }
    }
}
