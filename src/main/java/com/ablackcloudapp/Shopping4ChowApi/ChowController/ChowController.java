package com.ablackcloudapp.Shopping4ChowApi.ChowController;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Ingredient;
import com.ablackcloudapp.Shopping4ChowApi.Service.iIngredientService;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
public class ChowController {

    @Autowired
    private iIngredientService ingredientService;

    @Autowired
    private AmazonS3 s3client;

    @ResponseBody
    @PostMapping("getIngredients")
    public List<Ingredient> getingredient(@RequestBody Ingredient ingredient){
        System.out.println("Search Item: " + ingredient.getName());
        List<Ingredient> ingredients = ingredientService.getIngredients(ingredient.getName());
        System.out.println(ingredients);
        return ingredients;
    }

    @ResponseBody
    @GetMapping("allingredients")
    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ingredients;
    }

    @ResponseBody
    @PostMapping("addingredient")
    public String addFood(@RequestParam("file") MultipartFile foodPic, @RequestPart("name") String name) {
    //public String addFood(@RequestBody Food food){
        System.out.println("Adding Ingredient");
        Ingredient ingredient = new Ingredient(name, foodPic);
        ingredientService.addIngredient(ingredient);
        return "Ingredient Added";
    }

}
