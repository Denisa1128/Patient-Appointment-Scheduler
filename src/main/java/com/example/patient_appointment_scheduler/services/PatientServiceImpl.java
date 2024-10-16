package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.repositories.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import com.example.patient_appointment_scheduler.models.entities.Patient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final ObjectMapper objectMapper;
    private final PatientRepository patientRepository;

    public PatientServiceImpl(ObjectMapper objectMapper, PatientRepository patientRepository) {
        this.objectMapper = objectMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO) {
        Patient patientEntity = objectMapper.convertValue(requestPatientDTO, Patient.class);
        Patient patientEntityResponse = patientRepository.save(patientEntity);
        log.info("Patient with id {} was saved", patientEntityResponse.getId());

        return objectMapper.convertValue(patientEntityResponse, ResponsePatientDTO.class);

    }
}