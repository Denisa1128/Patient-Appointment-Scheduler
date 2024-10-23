package com.example.patient_appointment_scheduler.exceptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice  extends ResponseEntityExceptionHandler {

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(objectToString(errors), BAD_REQUEST);
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