package com.ablackcloudapp.Shopping4ChowApi.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="recipe_pics")
public class RecipePics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="recipe_id")
    private Meal meal;

    @Column(name="s3_url")
    private String s3Url;
}
