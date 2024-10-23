package com.example.patient_appointment_scheduler.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "This field is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String email;
    @NotNull
    private String address;
}
