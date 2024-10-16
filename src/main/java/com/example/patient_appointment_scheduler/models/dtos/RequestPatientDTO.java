package com.example.patient_appointment_scheduler.models.dtos;

import lombok.Data;

@Data
public class RequestPatientDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
