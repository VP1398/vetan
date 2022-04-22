package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.ReimburseEntity;

@Repository
public interface ReimburseRepository
			extends CrudRepository<ReimburseEntity, Long> {

}
