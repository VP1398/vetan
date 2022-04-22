package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemFestivalAdvEntity;

@Repository
public interface RemFestivalAdvRepository
			extends CrudRepository<RemFestivalAdvEntity, Long> {

}
