package com.apec.pos.repository;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.RestaurantEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class RestaurantRepository extends BaseRepository<RestaurantEntity, Long>{

	@Autowired
	private EntityManager entityManager;
	
	public RestaurantRepository() {
		super(RestaurantEntity.class);
	}
	
	public List<RestaurantEntity> getRecommendRes() {
		String queryString = "SELECT c FROM RestaurantEntity c ORDER BY c.quantitySold DESC";
		Query query = entityManager.createQuery(queryString);
		return query.setMaxResults(10).getResultList();
	}

}
