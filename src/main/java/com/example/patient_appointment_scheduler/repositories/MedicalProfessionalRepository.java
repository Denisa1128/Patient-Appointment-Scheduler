package com.example.patient_appointment_scheduler.repositories;

import com.example.patient_appointment_scheduler.models.entities.MedicalProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalProfessionalRepository extends JpaRepository<MedicalProfessional , Long > {


}
