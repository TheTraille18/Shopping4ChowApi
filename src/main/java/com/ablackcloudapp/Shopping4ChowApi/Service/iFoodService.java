package com.ablackcloudapp.Shopping4ChowApi.Service;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Food;

import java.util.List;

public interface iFoodService {
    public List<Food> getFoods();
    public void addFood(String name);
}
