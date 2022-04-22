package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvTransferEntity;

@Repository
public interface LvTransferRepository 
			extends CrudRepository<LvTransferEntity, Long> {

}
