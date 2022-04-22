package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvMaternityEntity;

@Repository
public interface LvMaternityRepository 
			extends CrudRepository<LvMaternityEntity, Long> {

}
