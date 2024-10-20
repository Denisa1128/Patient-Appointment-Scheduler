package com.example.patient_appointment_scheduler.exceptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> patientNotFoundException(PatientNotFoundException patientNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", patientNotFoundException.getMessage())), NOT_FOUND);

    }

    @ExceptionHandler(MedicalProfessionalNotFoundException.class)
    public ResponseEntity<String> medicalProfessionalNotFoundException(MedicalProfessionalNotFoundException medicalProfessionalNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", medicalProfessionalNotFoundException.getMessage())), NOT_FOUND);

    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<String> appointmentNotFoundException(AppointmentNotFoundException appointmentNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", appointmentNotFoundException.getMessage())), NOT_FOUND);
    }

    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error("Error processing response to string");
            return "Internal error";
        }
    }
}