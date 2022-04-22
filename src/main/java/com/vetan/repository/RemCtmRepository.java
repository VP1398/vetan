package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemCtmEntity;

@Repository
public interface RemCtmRepository
			extends CrudRepository<RemCtmEntity, Long> {

}
