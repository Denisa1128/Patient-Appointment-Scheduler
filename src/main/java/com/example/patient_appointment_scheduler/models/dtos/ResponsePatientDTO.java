package com.example.patient_appointment_scheduler.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponsePatientDTO {
    @NotNull
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int age;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String address;

}



