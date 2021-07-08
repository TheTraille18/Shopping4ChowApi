package com.ablackcloudapp.Shopping4ChowApi.Service;

import com.ablackcloudapp.Shopping4ChowApi.Dao.iFoodDao;
import com.ablackcloudapp.Shopping4ChowApi.Entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodServiceImpl implements iFoodService {

    @Autowired
    private iFoodDao foodDao;

    @Override
    @Transactional
    public List<Food> getFoods() {
        return foodDao.getFoods();
    }

    @Override
    public void addFood(String name) {
        foodDao.addFood(name);
    }
}
