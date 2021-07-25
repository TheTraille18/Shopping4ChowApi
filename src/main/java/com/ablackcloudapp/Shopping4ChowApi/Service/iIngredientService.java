package com.ablackcloudapp.Shopping4ChowApi.Service;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Ingredient;

import java.util.List;

public interface iIngredientService {
    public List<Ingredient> getIngredients(String findIngredients);
    public void removeIngredient(int ingredientId);
    public List<Ingredient> getAllIngredients();
    public void addIngredient(Ingredient ingredient);
}
