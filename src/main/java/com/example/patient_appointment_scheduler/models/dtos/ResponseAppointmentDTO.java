package com.example.patient_appointment_scheduler.models.dtos;

import com.example.patient_appointment_scheduler.models.dtos.ResponseMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseAppointmentDTO {

    private Long id;
    private ResponsePatientDTO patient;
    private ResponseMedicalProfessionalDTO medicalProfessional;
    private LocalDateTime appointmentDateTime;
    private String status;
    private String treatmentDetails;
}