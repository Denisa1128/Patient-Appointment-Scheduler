package com.example.patient_appointment_scheduler.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestPatientDTO {

    @NotBlank(message = "FirstName is required")
    private String firstName;
    @NotBlank(message = "LastName is required")
    private String lastName;
    private LocalDate dateOfBirth;
    private int age;
    private String phone;
    private String email;
    private String address;

}
