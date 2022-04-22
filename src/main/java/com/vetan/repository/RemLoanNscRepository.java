package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemLoanNscEntity;

@Repository
public interface RemLoanNscRepository
			extends CrudRepository<RemLoanNscEntity, Long> {

}
