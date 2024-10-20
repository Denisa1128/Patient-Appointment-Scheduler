package com.example.patient_appointment_scheduler.unit_tests;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import com.example.patient_appointment_scheduler.models.entities.Patient;
import com.example.patient_appointment_scheduler.repositories.PatientRepository;
import com.example.patient_appointment_scheduler.services.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {
    @Mock
    ObjectMapper objectMapper;

    @Mock
    PatientRepository patientRepository;

    @Mock
    PatientServiceImpl patientService;


    @Test
    void createPatient() {


        RequestPatientDTO requestPatientDTO = new RequestPatientDTO();
        requestPatientDTO.setFirstName("Sarah");
        requestPatientDTO.setLastName("Levis");
        requestPatientDTO.setPhone("07569822");
        requestPatientDTO.setAge(31);
        requestPatientDTO.setEmail("sarahl@gmail.com");
        requestPatientDTO.setAddress("125 Sun St");

        ResponsePatientDTO responsePatientDTO = new ResponsePatientDTO();
        requestPatientDTO.setFirstName("Sarah");
        requestPatientDTO.setLastName("Levis");
        requestPatientDTO.setPhone("07569822");
        requestPatientDTO.setAge(31);
        requestPatientDTO.setEmail("sarahl@gmail.com");
        requestPatientDTO.setAddress("125 Sun St");

        Patient patientEntity = new Patient();
        patientEntity.setId(1L);
        patientEntity.setFirstName("Sarah");
        patientEntity.setLastName("Levis");
        patientEntity.setPhone("07569822");
        patientEntity.setAge(31);
        patientEntity.setEmail("sarahl@gmail.com");
        patientEntity.setAddress("125 Sun St");

        Patient savedPatientEntity = new Patient();
        savedPatientEntity.setId(1L);
        savedPatientEntity.setFirstName("Sarah");
        savedPatientEntity.setLastName("Levis");
        savedPatientEntity.setPhone("07569822");
        savedPatientEntity.setAge(31);
        savedPatientEntity.setEmail("sarahl@gmail.com");
        savedPatientEntity.setAddress("125 Sun St");


        when(objectMapper.convertValue(requestPatientDTO, Patient.class)).

                thenReturn(patientEntity);

        when(patientRepository.save(patientEntity)).

                thenReturn(patientEntity);

        when(objectMapper.convertValue(savedPatientEntity, ResponsePatientDTO.class)).

                thenReturn(responsePatientDTO);

        ResponsePatientDTO savedPatientDTO = patientService.createPatient(requestPatientDTO);


        verify(patientRepository, times(1)).save(patientEntity);
        assertEquals(requestPatientDTO.getFirstName(), savedPatientDTO.getFirstName());
        assertEquals(requestPatientDTO.getLastName(), savedPatientDTO.getLastName());}}