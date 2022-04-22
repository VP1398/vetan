package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.ExpenseEntity;

@Repository
public interface ExpenseRepository
			extends CrudRepository<ExpenseEntity, Long> {

}
