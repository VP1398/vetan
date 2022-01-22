package com.vetan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vetan.data.hra;


@Repository
public interface ReportRepository extends JpaRepository<hra, Long> {

	
}