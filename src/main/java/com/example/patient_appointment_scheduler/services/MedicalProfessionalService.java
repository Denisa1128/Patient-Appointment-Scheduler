package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.dtos.RequestMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseMedicalProfessionalDTO;

import java.util.List;

public interface MedicalProfessionalService {

    ResponseMedicalProfessionalDTO createMedicalProfessional(RequestMedicalProfessionalDTO requestMedicalProfessionalDTO);

    void deleteMedicalProfessionalById(Long id);

    List<ResponseMedicalProfessionalDTO> getMedicalProfessional();

    ResponseMedicalProfessionalDTO updateMedicalProfessional(Long id, RequestMedicalProfessionalDTO requestMedicalProfessionalDTO);
}
