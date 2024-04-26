package com.example.systems_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inspection_company_id")
    private InspectionCompany inspectionCompany;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Inspection> inspections;

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Device setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }

    public InspectionCompany getInspectionCompany() {
        return inspectionCompany;
    }

    public Device setInspectionCompany(InspectionCompany inspectionCompany) {
        this.inspectionCompany = inspectionCompany;
        return this;
    }

    public List<Inspection> getInspections() {
        return inspections;
    }

    public Device setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
        return this;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
