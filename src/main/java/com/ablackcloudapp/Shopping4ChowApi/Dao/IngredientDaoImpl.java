package com.ablackcloudapp.Shopping4ChowApi.Dao;

import com.ablackcloudapp.Shopping4ChowApi.Entity.Ingredient;
import com.amazonaws.services.s3.AmazonS3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class IngredientDaoImpl implements iIngredientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AmazonS3 s3Client;

    @Override
    public void addIngredient(Ingredient ingredient) {
        System.out.println("Creating food file");
        String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        File tempFile = new File(currentDirectory + "/" + ingredient.getName());
        try {
            String uploadedFileName = ingredient.getIngredientPicFile().getOriginalFilename();
            String extention = uploadedFileName.substring(uploadedFileName.lastIndexOf("."));
            String fileName = ingredient.getName() + extention;
            tempFile.createNewFile();
            ingredient.getIngredientPicFile().transferTo(tempFile);
            String env = getEnvironment();
            ingredient.setS3Key(env + fileName);
            s3Client.putObject("shopping4chow.com", env + ingredient.getName(), tempFile);
            Session session = sessionFactory.getCurrentSession();
            session.save(ingredient);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Boolean delete = tempFile.delete();
        }

    }

    @Override
    public List<Ingredient> getIngredients(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Searching.......");
        System.out.println(name);
        List<Ingredient> ingredients = session.createQuery("from Ingredient where name like '"  + name + "%'").getResultList();
        System.out.println("Search Complete");
        System.out.println(ingredients);
        session.getTransaction().commit();
        return ingredients;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Beginning Querying");
        List<Ingredient> ingredients = session.createQuery("from Ingredient").getResultList();
        System.out.println("Finished querying");
        session.getTransaction().commit();
        return ingredients;
    }

    private String getEnvironment(){
        String environment = System.getenv("S4C_ENVIRONMENT");
        System.out.println("Environment: " + environment);
        String env = "";
        switch(environment){
            case "LOCAL":
                env = "local/";
                break;
            default:
                env = "";
        }
        return env;
    }
}
