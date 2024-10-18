package com.example.patient_appointment_scheduler.controllers;

import com.example.patient_appointment_scheduler.models.dtos.RequestMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.services.MedicalProfessionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-professional")
public class MedicalProfessionalController {

    private final MedicalProfessionalService medicalProfessionalService;

    public MedicalProfessionalController(MedicalProfessionalService medicalProfessionalService) {
        this.medicalProfessionalService = medicalProfessionalService;
    }

    @PostMapping
    public ResponseEntity<ResponseMedicalProfessionalDTO> createMedicalProfessional(@RequestBody RequestMedicalProfessionalDTO requestMedicalProfessionalDTO) {
        return ResponseEntity.ok(medicalProfessionalService.createMedicalProfessional(requestMedicalProfessionalDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseMedicalProfessionalDTO>> getMedicalProfessionals() {
        return ResponseEntity.ok(medicalProfessionalService.getMedicalProfessional());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseMedicalProfessionalDTO> updateMedicalProfessional(@PathVariable Long id, @RequestBody RequestMedicalProfessionalDTO requestMedicalProfessionalDTO) {
        return ResponseEntity.ok(medicalProfessionalService.updateMedicalProfessional(id, requestMedicalProfessionalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalProfessionalById(@PathVariable  Long id) {
        medicalProfessionalService.deleteMedicalProfessionalById(id);
        return ResponseEntity.noContent().build();
    }


}
