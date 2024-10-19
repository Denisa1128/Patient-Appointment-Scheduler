package com.example.patient_appointment_scheduler.exceptions;

public class AppointmentNotFoundException extends RuntimeException {

    public AppointmentNotFoundException(String message){
        super(message);
    }
}
