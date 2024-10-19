package com.example.patient_appointment_scheduler.models.dtos;

import lombok.Data;

@Data
public class ResponseMedicalProfessionalDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String phone;
    private String email;
}
