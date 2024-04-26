package com.example.systems_management.repository;

import com.example.systems_management.entities.InspectionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionCompanyRepository extends JpaRepository<InspectionCompany, Long> {

    InspectionCompany readInspectionCompanyById(Long id);
}
