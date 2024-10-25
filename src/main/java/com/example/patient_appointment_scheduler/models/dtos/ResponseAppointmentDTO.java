package com.example.patient_appointment_scheduler.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseAppointmentDTO {

    private Long id;
    private String patient;
    private String doctor;
    private LocalDateTime appointmentDateTime;
    private String status;
    private String treatmentDetails;
}
