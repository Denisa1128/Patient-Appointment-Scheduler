package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.entities.Patient;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecification {
    public static Specification<Patient> firstNameContains(String firstName) {
        return (patient, query, criteriaBuilder) -> firstName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(patient.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Patient> lastNameContains(String lastName) {
        return (patient, query, criteriaBuilder) -> lastName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(patient.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }
}
