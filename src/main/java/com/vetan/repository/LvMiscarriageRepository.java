package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvMiscarriageEntity;

@Repository
public interface LvMiscarriageRepository 
			extends CrudRepository<LvMiscarriageEntity, Long> {

}
