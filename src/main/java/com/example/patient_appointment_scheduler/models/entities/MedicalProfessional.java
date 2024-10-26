package com.example.patient_appointment_scheduler.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Table(name = "medical_professionals")
@Entity
@Data
public class MedicalProfessional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "specialty")
    private String speciality;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "medicalProfessional", cascade = CascadeType.ALL)
    @JsonManagedReference ("professional-appointment")
    private List<Appointment> appointments;
}