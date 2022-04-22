package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvSickEntity;

@Repository
public interface EmpLvSickRepository 
			extends CrudRepository<EmpLvSickEntity, Long> {

}
