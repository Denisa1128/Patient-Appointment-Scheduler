package com.example.patient_appointment_scheduler.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {

        super(message);
    }
}
