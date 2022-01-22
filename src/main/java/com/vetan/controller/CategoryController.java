package com.vetan.controller;

import com.vetan.hibernate.pojo.ProductCategory;
import com.vetan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("category")
public class CategoryController {


    @Autowired
    ProductService service;

    @RequestMapping(method = RequestMethod.POST,value = "create")
    @ResponseBody
    public ProductCategory saveCategory(@RequestBody ProductCategory category){

        ProductCategory cateogry = service.saveProductCategory(category);

        return cateogry;
    }



}
