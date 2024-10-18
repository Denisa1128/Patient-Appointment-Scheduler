package com.example.patient_appointment_scheduler.models.entities;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "medical-professionals")
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
    private String specialty;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
}
