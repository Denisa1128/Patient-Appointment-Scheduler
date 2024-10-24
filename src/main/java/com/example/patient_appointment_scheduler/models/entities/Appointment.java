package com.example.patient_appointment_scheduler.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private MedicalProfessional medicalProfessional;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "appointment_date_time")
    private LocalDateTime appointmentDateTime;
    @Column(name = "status")
    private String status;
    @Column(name = "treatment_details")
    private String treatmentDetails;
}
