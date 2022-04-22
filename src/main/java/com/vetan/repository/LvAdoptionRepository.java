package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvAdoptionEntity;

@Repository
public interface LvAdoptionRepository 
			extends CrudRepository<LvAdoptionEntity, Long> {

}
