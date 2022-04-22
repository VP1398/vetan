package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.EmprLvEntity;

@Repository
public interface EmprLvRepository
			extends CrudRepository<EmprLvEntity, Long> {

}
