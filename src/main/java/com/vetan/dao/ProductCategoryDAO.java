package com.vetan.dao;

import com.vetan.hibernate.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//extends JpaRepository<ProductCategory,Integer>


public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer> {

}
