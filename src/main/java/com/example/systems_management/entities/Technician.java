package com.example.systems_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
@Table(name = "technicians")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    private String firstName;

    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotNull
    private Date passValidityDate;

    private Long phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "inspection_company_id")
    private InspectionCompany inspectionCompany;

    public Technician() {
    }

    public Technician(String firstName, String lastName, Date passValidityDate, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passValidityDate = passValidityDate;
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Technician setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public Technician setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getPassValidityDate() {
        return passValidityDate;
    }

    public Technician setPassValidityDate(Date passValidityDate) {
        this.passValidityDate = passValidityDate;
        return this;
    }

    public InspectionCompany getInspectionCompany() {
        return inspectionCompany;
    }

    public Technician setInspectionCompany(InspectionCompany inspectionCompany) {
        this.inspectionCompany = inspectionCompany;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Technician setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
