package com.vetan.controller;

import com.vetan.hibernate.pojo.ProductCategory;
import com.vetan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService service;

    @ResponseBody
    @GetMapping("hello")
    public String sayHello(){
        service.printHello();
        return "Hello,Dileep";
    }

    @GetMapping("index")
    public String indexPage(){
        return "index";
    }


    @GetMapping("dashboard*")
    public String dashboardPage(){
    	
    	
        return "dashboard";
    }

    @RequestMapping(method = RequestMethod.GET,value = "getCategories")
    @ResponseBody
    public List<ProductCategory> getProductCategoryList(){
        return service.getCategoriesList();
    }



}
