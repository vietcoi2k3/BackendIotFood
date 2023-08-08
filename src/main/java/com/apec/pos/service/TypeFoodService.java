package com.apec.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.entity.TypeFoodEntity;
import com.apec.pos.repository.TypeFoodRepository;
import com.apec.pos.service.serviceInterface.TypeFoodInterface;

@Service
public class TypeFoodService extends BaseService<TypeFoodRepository, TypeFoodEntity, Integer> implements TypeFoodInterface{

	@Autowired
	private TypeFoodRepository typeFoodRepository;
	
	@Override
	public TypeFoodEntity addTypeFood(TypeFoodEntity typeFoodEntity) {
		return typeFoodRepository.insert(typeFoodEntity);
	}



	@Override
	TypeFoodRepository getRepository() {
		// TODO Auto-generated method stub
		return typeFoodRepository;
	}

}
