package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvPaternityEntity;

@Repository
public interface EmpLvPaternityRepository 
			extends CrudRepository<EmpLvPaternityEntity, Long> {

}
