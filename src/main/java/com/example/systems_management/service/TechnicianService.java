package com.example.systems_management.service;

import com.example.systems_management.entities.Technician;
import com.example.systems_management.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Optional<Technician> getTechnicianByIdOptional(Long id) {
        return technicianRepository.findById(id);
    }

    public Technician getTechnicianById(Long id) {
        return technicianRepository.getTechniciansById(id);
    }
    public void save(Technician technician) {
        technicianRepository.save(technician);
    }

    public List<Technician> getTechniciansByInspCompId(Long id){
        return technicianRepository.getTechniciansByInspectionCompanyId(id);
    }

    public void delete(Long id) {
        technicianRepository.deleteById(id);
    }
}
