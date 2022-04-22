package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemPlEntity;

@Repository
public interface RemPlRepository
			extends CrudRepository<RemPlEntity, Long> {

}
