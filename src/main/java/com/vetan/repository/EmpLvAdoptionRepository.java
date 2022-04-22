package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvAdoptionEntity;

@Repository
public interface EmpLvAdoptionRepository 
			extends CrudRepository<EmpLvAdoptionEntity, Long> {

}
