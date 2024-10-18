package com.example.patient_appointment_scheduler.exceptions;

public class MedicalProfessionalNotFoundException extends RuntimeException {

    public MedicalProfessionalNotFoundException(String message) {
        super(message);
    }
}
