package com.example.patient_appointment_scheduler.controllers;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.example.patient_appointment_scheduler.models.entities.Patient;
import com.example.patient_appointment_scheduler.services.PatientService;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping()
    public ResponseEntity<List<ResponsePatientDTO>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponsePatientDTO> updatePatient(@PathVariable Long id, @RequestBody RequestPatientDTO requestPatientDTO){
        return ResponseEntity.ok(patientService.updatePatient(id ,requestPatientDTO));
    }

}

