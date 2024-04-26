package com.example.systems_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "inspectionCompany")
public class InspectionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "inspectionCompany")
    private List<Technician> technician;

    @OneToMany(mappedBy = "inspectionCompany")
    private List<Device> devices;

    public InspectionCompany() {
    }

    public InspectionCompany(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public InspectionCompany setName(String name) {
        this.name = name;
        return this;
    }

    public List<Technician> getTechnician() {
        return technician;
    }

    public InspectionCompany setTechnician(List<Technician> technician) {
        this.technician = technician;
        return this;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public InspectionCompany setDevices(List<Device> systems) {
        this.devices = systems;
        return this;
    }
}
