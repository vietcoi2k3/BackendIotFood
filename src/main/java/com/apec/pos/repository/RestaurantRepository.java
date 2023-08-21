package com.apec.pos.repository;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.RestaurantEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class RestaurantRepository extends BaseRepository<RestaurantEntity, Integer>{

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

	public List<RestaurantEntity> searchRes(String key){
		String queryString = "SELECT c FROM RestaurantEntity c "
				+ "WHERE c.restaurantName like :key";
		
		Query query2 = entityManager.createQuery(queryString);
		query2.setParameter("key", "%"+key+"%");
		return query2.getResultList();
	}
}
