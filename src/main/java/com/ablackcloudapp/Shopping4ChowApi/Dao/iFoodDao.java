package com.ablackcloudapp.Shopping4ChowApi.Dao;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Food;

import java.util.List;

public interface iFoodDao {
    void addFood(String name);
    Food getFood(String name);
    List<Food> getFoods();
}
