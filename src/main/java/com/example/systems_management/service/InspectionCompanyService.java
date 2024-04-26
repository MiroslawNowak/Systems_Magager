package com.example.systems_management.service;

import com.example.systems_management.entities.InspectionCompany;
import com.example.systems_management.repository.InspectionCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionCompanyService {
    private final InspectionCompanyRepository inspCompRepo;

    public InspectionCompanyService(InspectionCompanyRepository inspCompRepo) {
        this.inspCompRepo = inspCompRepo;
    }

    public List<InspectionCompany> getAllInspCompanies() {
        return inspCompRepo.findAll();
    }
    public void add(InspectionCompany inspectionCompany) {
        inspCompRepo.save(inspectionCompany);
    }

    public Optional<InspectionCompany> readByIdOptional(Long id) {
        return inspCompRepo.findById(id);
    }

    public InspectionCompany readById(Long id) {
        return inspCompRepo.readInspectionCompanyById(id);
    }
}
