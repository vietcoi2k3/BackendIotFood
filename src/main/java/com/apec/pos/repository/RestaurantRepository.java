package com.apec.pos.repository;


import org.springframework.stereotype.Repository;

import com.apec.pos.entity.RestaurantEntity;

@Repository
public class RestaurantRepository extends BaseRepository<RestaurantEntity, Long>{

	public RestaurantRepository() {
		super(RestaurantEntity.class);
	}

}
