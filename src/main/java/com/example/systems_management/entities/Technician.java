package com.example.systems_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
@Table(name = "technicians")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Podaj imię")
    @Size(min = 3, message = "Imię musi zawierać conajmniej trzy znaki")
    private String firstName;

    @NotNull
    @NotEmpty(message = "Podaj nazwisko")
    @Size(min = 2, message = "Nazwisko musi zawierać conajmniej dwa znaki")
    private String lastName;

    @NotNull(message = "Wybierz datę ważności przepustki")
    private Date passValidityDate;

    @NotEmpty(message = "Podaj numer telefonu")
    @Size(min = 9, max = 9, message = "Podaj dziewięciocyfrowy numer telefonu")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Wybierz firmę. Jeżeli nie ma dostępnych opcji, w pierwszej kolejności dodaj nową firmę z innego formularza.")
    @JoinColumn(name = "inspection_company_id")
    private InspectionCompany inspectionCompany;

    public Technician() {
    }

    public Technician(String firstName, String lastName, Date passValidityDate, String phoneNumber) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Technician setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
