package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;

import java.util.List;

public interface PatientService {

    ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO);
    List<ResponsePatientDTO> getPatients();
    ResponsePatientDTO updatePatient(Long id,RequestPatientDTO requestPatientDTO);
}
