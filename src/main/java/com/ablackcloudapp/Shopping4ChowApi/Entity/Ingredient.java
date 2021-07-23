package com.ablackcloudapp.Shopping4ChowApi.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="s3key")
    private String s3Key;

    @Column(name="preferred_store")
    private String preferred_store;

    //Mark as Transients to indicate not mapped to a column
    @Transient
    private MultipartFile ingredientPicFile;

    public Ingredient(){

    }
    public Ingredient(String name){
        this.name = name;
    }
    public Ingredient(String name, MultipartFile ingredientPicFile){
        this.name = name;
        this.ingredientPicFile = ingredientPicFile;
    }
}
