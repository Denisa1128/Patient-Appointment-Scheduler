package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.exceptions.PatientNotFoundException;
import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.repositories.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import com.example.patient_appointment_scheduler.models.entities.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @Override
    public List<ResponsePatientDTO> getPatients() {
        List<Patient> patientDTOList = patientRepository.findAll();
        return patientDTOList.stream()
                .map(patient -> objectMapper.convertValue(patient, ResponsePatientDTO.class))
                .toList();

    }

    @Override
    public ResponsePatientDTO updatePatient(Long patientId, RequestPatientDTO requestPatientDTO) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient with id " + patientId + "not found"));


        if (requestPatientDTO.getFirstName() != null) {
            patient.setFirstName(requestPatientDTO.getFirstName());
        }
        if (requestPatientDTO.getLastName() != null) {
            patient.setLastName(requestPatientDTO.getLastName());
        }
        if (requestPatientDTO.getPhone() != null) {
            patient.setPhone(requestPatientDTO.getPhone());
        }
        if (requestPatientDTO.getEmail() != null) {
            patient.setEmail(requestPatientDTO.getEmail());
        }

        if (requestPatientDTO.getAddress() != null) {
            patient.setAddress(requestPatientDTO.getAddress());

        }
        Patient updatedPatient = patientRepository.save(patient);


        return objectMapper.convertValue(updatedPatient, ResponsePatientDTO.class);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient with id " + id + "not found"));
        patientRepository.deleteById(id);
        log.info("Patient with id {} was deleted", id);
    }
}