package com.example.patient_appointment_scheduler.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestMedicalProfessionalDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String specialty;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String address;
}
