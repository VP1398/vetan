package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvCasualEntity;

@Repository
public interface LvCasualRepository 
			extends CrudRepository<LvCasualEntity, Long> {

}
