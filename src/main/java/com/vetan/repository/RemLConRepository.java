package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemLConEntity;

@Repository
public interface RemLConRepository
			extends CrudRepository<RemLConEntity, Long> {

}
