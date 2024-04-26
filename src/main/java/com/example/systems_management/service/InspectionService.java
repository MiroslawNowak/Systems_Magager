package com.example.systems_management.service;

import com.example.systems_management.entities.Inspection;
import com.example.systems_management.repository.InspectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectionService {
    private final InspectionRepository inspRepo;

    public InspectionService(InspectionRepository inspRepo) {
        this.inspRepo = inspRepo;
    }

    public List<Inspection> getAllByDeviceId(Long id) {
        return inspRepo.findAllByDeviceId(id);
    }

    public void save(Inspection inspection) {
        inspRepo.save(inspection);
    }

    public List<Inspection> findAll () {
        return inspRepo.findAll();
    }
}

