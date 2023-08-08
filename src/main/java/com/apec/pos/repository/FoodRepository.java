package com.apec.pos.repository;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.apec.pos.entity.FoodEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class FoodRepository extends BaseRepository<FoodEntity, Integer>{

	public FoodRepository() {
		super(FoodEntity.class);
	}
	
	@Autowired
	private EntityManager entityManager;
	
	public List<FoodEntity> findFoodOnType(FoodEntity foodEntity){
		String query = buildQuery(foodEntity);
		Map<String, Object> params = getParams(foodEntity);
		return query(query, false,params);
	}
	
	public List<FoodEntity> getTopFood(){
		String query= "SELECT c FROM FoodEntity c";
		Query query2 = entityManager.createQuery(query);
		return query2.setMaxResults(10).getResultList();
	}

	private String buildQuery(FoodEntity foodEntity) {
        String query = "FROM AccountEntity c WHERE 1=1 ";
        if (foodEntity.getId() > 0) {
            query += " AND c.id = :id";
        }
        return query;
    }
	
    private	Map<String, Object> getParams(FoodEntity foodEntity) {
	        Map<String, Object> params = new HashMap<>();
	        if (foodEntity.getId() > 0) {
	            params.put("id", foodEntity.getId());
	        }   

	        return params;
	 }
}
