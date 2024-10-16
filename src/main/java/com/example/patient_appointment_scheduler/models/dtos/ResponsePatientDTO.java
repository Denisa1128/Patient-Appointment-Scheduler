package com.example.patient_appointment_scheduler.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponsePatientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
    private String address;

}



