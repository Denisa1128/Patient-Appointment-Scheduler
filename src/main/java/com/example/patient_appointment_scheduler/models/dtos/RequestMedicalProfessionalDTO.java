package com.example.patient_appointment_scheduler.models.dtos;

import lombok.Data;

@Data
public class RequestMedicalProfessionalDTO {

    private String firstName;
    private String lastName;
    private String specialty;
    private String phone;
    private String email;
    private String address;

}
