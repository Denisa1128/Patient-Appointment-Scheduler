package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;

public interface PatientService {

    ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO);
}