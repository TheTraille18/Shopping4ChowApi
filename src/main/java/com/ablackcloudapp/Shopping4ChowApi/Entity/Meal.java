package com.ablackcloudapp.Shopping4ChowApi.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="meal")
public class Meal {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    @Column(name="pic_id")
    private String pic_id;

    @Column(name="recipe_text")
    private String recipe_text;

    @Column(name="website")
    private String website;

    public Meal(){

    }

    public Meal(String name){
        this.name = name;
    }
}
