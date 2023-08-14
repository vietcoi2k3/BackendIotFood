package com.apec.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	public List<TypeFoodEntity> paging(int pageSize,int pageIndex){
		PageRequest pageRequest =  PageRequest.of(pageIndex, pageSize);
		return typeFoodRepository.paging(pageRequest);
	}

}
