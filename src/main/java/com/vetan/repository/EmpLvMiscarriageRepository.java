package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvMiscarriageEntity;

@Repository
public interface EmpLvMiscarriageRepository 
			extends CrudRepository<EmpLvMiscarriageEntity, Long> {

}
