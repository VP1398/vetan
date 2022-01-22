package com.vetan.dao;

import com.vetan.data.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NominationDAO extends JpaRepository<Nominee,String> {

    List<Nominee> findByType(String type);

}
