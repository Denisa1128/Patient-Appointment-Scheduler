package com.example.patient_appointment_scheduler.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestAppointmentDTO {
    @NotNull
    private Long patientId;
    @NotNull
    private Long professionalId;
    @NotNull
    private LocalDateTime appointmentDateTime;
    @NotNull
    private String status;
    @NotNull
    private String treatmentDetails;

}
