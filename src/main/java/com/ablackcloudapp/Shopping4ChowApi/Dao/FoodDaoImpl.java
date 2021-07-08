package com.ablackcloudapp.Shopping4ChowApi.Dao;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodDaoImpl implements iFoodDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addFood(String name) {
        Session session = sessionFactory.getCurrentSession();

        Food food = new Food(name);

        session.save(food);
    }

    @Override
    public Food getFood(String name) {
        return null;
    }

    @Override
    public List<Food> getFoods() {
        return null;
    }
}
