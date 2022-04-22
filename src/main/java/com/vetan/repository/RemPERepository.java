package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemPEEntity;

@Repository
public interface RemPERepository
			extends CrudRepository<RemPEEntity, Long> {

}
