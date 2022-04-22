package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.LvPrivilegeEntity;

@Repository
public interface LvPrivilegeRepository 
			extends CrudRepository<LvPrivilegeEntity, Long> {

}
