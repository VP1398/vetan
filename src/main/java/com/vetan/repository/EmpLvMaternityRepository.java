package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvMaternityEntity;

@Repository
public interface EmpLvMaternityRepository 
			extends CrudRepository<EmpLvMaternityEntity, Long> {

}
