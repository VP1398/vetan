package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmpLvPrivilegeEntity;

@Repository
public interface EmpLvPrivilegeRepository 
			extends CrudRepository<EmpLvPrivilegeEntity, Long> {

}
