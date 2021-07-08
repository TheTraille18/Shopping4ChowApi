package com.ablackcloudapp.Shopping4ChowApi.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="recipes")
public class Recipe {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredients> ingredients;

    @Column(name="pic_id")
    private String pic_id;

    @Column(name="recipe_text")
    private String recipe_text;

    @Column(name="website")
    private String website;

    public Recipe(){

    }

    public Recipe(String name){
        this.name = name;
    }
}
