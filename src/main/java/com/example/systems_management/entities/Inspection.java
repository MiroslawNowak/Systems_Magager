package com.example.systems_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@Table(name = "inspection")
public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String inspectionEmail;

    @NotNull
    private Date inspectionDate;

    @NotNull
    private String inspectionType;

    @ManyToOne()
    @JoinColumn(name = "device_id")
    private Device device;


    public Inspection() {
    }

    public Inspection(String periodicity, Date inspectionDate, String inspectionType, Device device) {
        this.inspectionEmail = periodicity;
        this.inspectionDate = inspectionDate;
        this.inspectionType = inspectionType;
        this.device = device;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getInspectionEmail() {
        return inspectionEmail;
    }

    public Inspection setInspectionEmail(String periodicity) {
        this.inspectionEmail = periodicity;
        return this;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public Inspection setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
        return this;
    }

    public String getInspectionType() {
        return inspectionType;
    }

    public Inspection setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
        return this;
    }

    public Device getDevice() {
        return device;
    }

    public Inspection setDevice(Device device) {
        this.device = device;
        return this;
    }
}
