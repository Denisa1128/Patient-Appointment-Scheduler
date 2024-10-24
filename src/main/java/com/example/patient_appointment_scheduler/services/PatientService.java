package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;

import java.util.List;

public interface PatientService {

    ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO);

    void deletePatientById(Long id);

    List<ResponsePatientDTO> getPatients(String firstName,String lastName);

    ResponsePatientDTO updatePatient(Long id, RequestPatientDTO requestPatientDTO);

}
