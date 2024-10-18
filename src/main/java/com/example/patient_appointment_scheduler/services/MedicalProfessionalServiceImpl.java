package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.exceptions.MedicalProfessionalNotFoundException;
import com.example.patient_appointment_scheduler.models.dtos.RequestMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.entities.MedicalProfessional;
import com.example.patient_appointment_scheduler.models.entities.Patient;
import com.example.patient_appointment_scheduler.repositories.MedicalProfessionalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MedicalProfessionalServiceImpl implements MedicalProfessionalService {
    private final ObjectMapper objectMapper;
    private final MedicalProfessionalRepository medicalProfessionalRepository;

    public MedicalProfessionalServiceImpl(ObjectMapper objectMapper, MedicalProfessionalRepository medicalProfessionalRepository) {
        this.objectMapper = objectMapper;
        this.medicalProfessionalRepository = medicalProfessionalRepository;
    }

    @Override
    public ResponseMedicalProfessionalDTO createMedicalProfessional(RequestMedicalProfessionalDTO requestMedicalProfessionalDTO) {
        MedicalProfessional medicalProfessionalEntity = objectMapper.convertValue(requestMedicalProfessionalDTO, MedicalProfessional.class);
        MedicalProfessional medicalProfessionalEntityResponse = medicalProfessionalRepository.save(medicalProfessionalEntity);
        log.info("Medical Professional with id {} was saved", medicalProfessionalEntityResponse.getId());

        return objectMapper.convertValue(medicalProfessionalEntityResponse, ResponseMedicalProfessionalDTO.class);
    }

    @Override
    public List<ResponseMedicalProfessionalDTO> getMedicalProfessional() {
        List<MedicalProfessional> medicalProfessionalDTOList = medicalProfessionalRepository.findAll();
        return medicalProfessionalDTOList.stream().map(medicalProfessional -> objectMapper.convertValue(medicalProfessional, ResponseMedicalProfessionalDTO.class)).toList();

    }

    @Override
    public ResponseMedicalProfessionalDTO updateMedicalProfessional(Long medicalProfessionalId, RequestMedicalProfessionalDTO requestMedicalProfessionalDTO) {
        MedicalProfessional medicalProfessional = medicalProfessionalRepository.findById(medicalProfessionalId).orElseThrow(() -> new MedicalProfessionalNotFoundException("Medical Professional with id " + medicalProfessionalId + "not found"));


        if (requestMedicalProfessionalDTO.getFirstName() != null) {
            medicalProfessional.setFirstName(requestMedicalProfessionalDTO.getFirstName());
        }
        if (requestMedicalProfessionalDTO.getLastName() != null) {
            medicalProfessional.setLastName(requestMedicalProfessionalDTO.getLastName());
        }
        if (requestMedicalProfessionalDTO.getPhone() != null) {
            medicalProfessional.setPhone(requestMedicalProfessionalDTO.getPhone());
        }
        if (requestMedicalProfessionalDTO.getEmail() != null) {
            medicalProfessional.setEmail(requestMedicalProfessionalDTO.getEmail());
        }


        MedicalProfessional updatedMedicalProfessional = medicalProfessionalRepository.save(medicalProfessional);
        return objectMapper.convertValue(updatedMedicalProfessional, ResponseMedicalProfessionalDTO.class);

    }

    @Override
    public void deleteMedicalProfessionalById(Long id) {
        medicalProfessionalRepository.findById(id).orElseThrow(() -> new MedicalProfessionalNotFoundException("Medical Professional with id" + id + "not found"));
        medicalProfessionalRepository.deleteById(id);
        log.info("Medical Professional with id {} was deleted", id);
    }

}