package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemLoanEntity;

@Repository
public interface RemLoanRepository
			extends CrudRepository<RemLoanEntity, Long> {

}
