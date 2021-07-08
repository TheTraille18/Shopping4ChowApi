package com.ablackcloudapp.Shopping4ChowApi.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="pic_url")
    private String pic_url;

    @Column(name="preferred_store")
    private String preferred_store;

    public Food(){

    }
    public Food(String name){
        this.name = name;
    }
}
