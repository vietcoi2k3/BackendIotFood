package com.apec.pos.repository;

import org.springframework.stereotype.Repository;

import com.apec.pos.entity.TypeFoodEntity;

@Repository
public class TypeFoodRepository extends BaseRepository<TypeFoodEntity, Integer>{

	public TypeFoodRepository( ) {
		super(TypeFoodEntity.class);
		// TODO Auto-generated constructor stub
	}
	
	

}
