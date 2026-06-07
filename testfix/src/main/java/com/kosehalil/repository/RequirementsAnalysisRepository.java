package com.kosehalil.repository;

import com.kosehalil.model.RequirementsAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementsAnalysisRepository extends JpaRepository<RequirementsAnalysis, Long> {
}