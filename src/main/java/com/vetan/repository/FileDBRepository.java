package com.vetan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetan.data.Vetan;

@Repository
public interface FileDBRepository extends JpaRepository<Vetan, String> {

}
