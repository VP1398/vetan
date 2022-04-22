package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemScholarEntity;

@Repository
public interface RemScholarRepository
			extends CrudRepository<RemScholarEntity, Long> {

}
