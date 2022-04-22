package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvPaternityEntity;

@Repository
public interface LvPaternityRepository 
			extends CrudRepository<LvPaternityEntity, Long> {

}
