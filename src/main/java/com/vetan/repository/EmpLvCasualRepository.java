package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvCasualEntity;

@Repository
public interface EmpLvCasualRepository 
			extends CrudRepository<EmpLvCasualEntity, Long> {

}
