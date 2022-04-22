package com.vetan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetan.model.RemTravelEntity;

@Repository
public interface RemTravelRepository
			extends CrudRepository<RemTravelEntity, Long> {

}
