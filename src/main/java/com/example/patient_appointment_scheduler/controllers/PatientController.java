package com.example.patient_appointment_scheduler.controllers;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.services.PatientService;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<ResponsePatientDTO> createPatient(@RequestBody RequestPatientDTO requestPatientDTO) {
        return ResponseEntity.ok(patientService.createPatient(requestPatientDTO));
    }

}

