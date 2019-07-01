package com.elasticsearch.controller;


import com.elasticsearch.pojo.dog;
import com.elasticsearch.service.Esteamplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class esController {
    @Autowired
    private Esteamplate esteamplate;

    @ResponseBody
    @GetMapping("adddog")
    public String adddog(String name, String dogtype, String detail) throws IOException {
        dog dog=new dog(name, dogtype,2, detail);
         JSONObject  jsonObject=esteamplate.addDogs("esindex","dog",dog);
          return jsonObject.toString();
    }

    @ResponseBody
    @GetMapping("searchdog")
    public String serchdog(String detail) throws IOException {
        return esteamplate.searchdog("esindex","dog",detail).toString();
    }
}
