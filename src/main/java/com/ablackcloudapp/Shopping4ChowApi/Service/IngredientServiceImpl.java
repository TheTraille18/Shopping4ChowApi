package com.ablackcloudapp.Shopping4ChowApi.Service;

import com.ablackcloudapp.Shopping4ChowApi.Dao.iIngredientDao;
import com.ablackcloudapp.Shopping4ChowApi.Entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements iIngredientService {

    @Autowired
    private iIngredientDao ingredientDaoImpl;

    public List<Ingredient> getIngredients(String findIngredients){
        List<Ingredient> ingredients = ingredientDaoImpl.getIngredients(findIngredients);
        return ingredients;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = ingredientDaoImpl.getAllIngredients();
        return ingredients;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientDaoImpl.addIngredient(ingredient);
    }
}
