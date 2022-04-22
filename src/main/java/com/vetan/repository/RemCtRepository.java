package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemCtEntity;

@Repository
public interface RemCtRepository
			extends CrudRepository<RemCtEntity, Long> {

}
