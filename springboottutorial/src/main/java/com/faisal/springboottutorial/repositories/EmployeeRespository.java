package com.faisal.springboottutorial.repositories;

import com.faisal.springboottutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends JpaRepository<EmployeeEntity, Long> {


}
