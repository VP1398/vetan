package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvTransferEntity;

@Repository
public interface EmpLvTransferRepository 
			extends CrudRepository<EmpLvTransferEntity, Long> {

}
