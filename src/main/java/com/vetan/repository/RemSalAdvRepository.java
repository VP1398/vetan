package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemSalAdvEntity;

@Repository
public interface RemSalAdvRepository
			extends CrudRepository<RemSalAdvEntity, Long> {

}
