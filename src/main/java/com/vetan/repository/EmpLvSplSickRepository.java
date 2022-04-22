package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvSplSickEntity;

@Repository
public interface EmpLvSplSickRepository 
			extends CrudRepository<EmpLvSplSickEntity, Long> {

}
