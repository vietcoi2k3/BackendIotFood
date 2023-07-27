package com.apec.pos.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.apec.pos.entity.FoodEntity;

@Repository
public class FoodRepository extends BaseRepository<FoodEntity, Integer>{

	public FoodRepository() {
		super(FoodEntity.class);
	}
	
	private List<FoodEntity> getTopFood(){
		String query= "FROM FoodEntity c LIMIT 4";
		return query(query, false);
	}

	private String buildQuery(FoodEntity foodEntity) {
        String query = "FROM AccountEntity c WHERE 1=1 ";
        if (foodEntity.getId() > 0) {
            query += " AND c.id = :id";
        }
        return query;
    }
	
	 public Map<String, Object> getParams(FoodEntity foodEntity) {
	        Map<String, Object> params = new HashMap<>();
	        if (foodEntity.getId() > 0) {
	            params.put("id", foodEntity.getId());
	        }     

	        return params;
	 }
}
