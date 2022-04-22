package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvSickEntity;

@Repository
public interface LvSickRepository 
			extends CrudRepository<LvSickEntity, Long> {

}
