package com.apec.pos.repository;

import com.apec.pos.entity.ToppingEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToppingRepository extends BaseRepository<ToppingEntity,Integer>{

    @Autowired
    private EntityManager entityManager;

    public ToppingRepository( ) {
        super(ToppingEntity.class);
    }

    @Transactional
    public void deleteByFoodId(Integer id){
        String queryString0 = "(SELECT f.id FROM FoodEntity f INNER JOIN RestaurantEntity r ON r.id = :id)";
        String deleteQuery = "DELETE FROM ToppingEntity t WHERE t.foodEntityId IN "+queryString0;
        Query query = entityManager.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
