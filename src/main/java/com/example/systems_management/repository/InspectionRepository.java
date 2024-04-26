package com.example.systems_management.repository;

import com.example.systems_management.entities.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Long> {
    List<Inspection> findAllByDeviceId(Long device_id);
}
