package com.example.systems_management.repository;

import com.example.systems_management.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    List<Technician> getTechniciansByInspectionCompanyId(Long id);

    Technician getTechniciansById(Long id);
}
