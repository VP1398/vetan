package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvExtraOrdinaryEntity;

@Repository
public interface LvExtraOrdinaryRepository 
			extends CrudRepository<LvExtraOrdinaryEntity, Long> {

}
