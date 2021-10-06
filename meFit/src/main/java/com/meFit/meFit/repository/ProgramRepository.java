package com.meFit.meFit.repository;

import com.meFit.meFit.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the ProgramModel gets extended with JPA functions
@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
}
