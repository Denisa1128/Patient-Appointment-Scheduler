package com.example.patient_appointment_scheduler.repositories;

import com.example.patient_appointment_scheduler.models.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment ,Long> {
}
