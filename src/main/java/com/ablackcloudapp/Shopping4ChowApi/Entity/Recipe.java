package com.ablackcloudapp.Shopping4ChowApi.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Column(name="name")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="ingredient_id")
    private Ingredient ingredient;

    @Column(name="amount")
    private int amount;

    @Column(name="units")
    private Unit units;

    public enum Unit {
        none,
        each,
        peice,
        bag,
        bottle,
        box,
        pack,
        jar,
        can,
        bunch,
        roll,
        dozen,
        small,
        large,
        lbs,
        qt,
        oz,
        cup,
        gallon,
        tbsp,
        tsp,
        g,
        kg,
        liter,
        milliliter,
        pis
    }
}

