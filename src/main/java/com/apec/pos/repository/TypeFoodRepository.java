package com.apec.pos.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.TypeFoodEntity;

@Repository
public class TypeFoodRepository extends BaseRepository<TypeFoodEntity, Integer>{

	public TypeFoodRepository( ) {
		super(TypeFoodEntity.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<TypeFoodEntity> paging(PageRequest pageRequest){
		String query = "FROM TypeFoodEntity c";
		return query(query, false,pageRequest);
	}

}
