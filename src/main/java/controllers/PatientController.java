package controllers;

import models.dtos.RequestPatientDTO;
import models.dtos.ResponsePatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.PatientService;

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

