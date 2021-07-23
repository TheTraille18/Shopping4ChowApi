package com.ablackcloudapp.Shopping4ChowApi.Dao;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Ingredient;

import java.util.List;

public interface iIngredientDao {
    void addIngredient(Ingredient ingredient);
    List<Ingredient> getIngredients(String name);
    List<Ingredient> getAllIngredients();
}
