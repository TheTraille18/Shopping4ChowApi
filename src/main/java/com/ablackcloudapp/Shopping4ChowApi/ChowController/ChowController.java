package com.ablackcloudapp.Shopping4ChowApi.ChowController;

import com.ablackcloudapp.Shopping4ChowApi.Service.iFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChowController {

    @Autowired
    private iFoodService foodService;

    @ResponseBody
    @GetMapping("test")
    public String test(){
        return "test";
    }

    @ResponseBody
    @GetMapping("addfood")
    public String addFood(){
        System.out.printf("Adding food");
        return null;
    }
}
