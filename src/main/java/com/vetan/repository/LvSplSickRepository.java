package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvSplSickEntity;

@Repository
public interface LvSplSickRepository 
			extends CrudRepository<LvSplSickEntity, Long> {

}
