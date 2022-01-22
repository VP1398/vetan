package com.vetan.service;

import com.vetan.dao.CategoryDAO;
import com.vetan.dao.ProductCategoryDAO;
import com.vetan.hibernate.pojo.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

     @Autowired
    ProductCategoryDAO productCategoryDAO;

    @Autowired
    CategoryDAO categoryDAO;

    public ProductCategory saveProductCategory(ProductCategory category){

        ProductCategory savedCategory =  productCategoryDAO.save(category);


        return savedCategory;
    }

    public void printHello(){

        System.out.println("Hello, Dileep");

    }


    public List<ProductCategory> getCategoriesList() {
        return productCategoryDAO.findAll();
    }
}
