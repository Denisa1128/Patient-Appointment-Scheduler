package com.example.patient_appointment_scheduler.controllers;

import com.example.patient_appointment_scheduler.models.dtos.RequestAppointmentDTO;
import com.example.patient_appointment_scheduler.models.dtos.RequestMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseAppointmentDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<ResponseAppointmentDTO> createAppointment(@RequestBody RequestAppointmentDTO requestAppointmentDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(requestAppointmentDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseAppointmentDTO>> getAppointment() {
        return ResponseEntity.ok(appointmentService.getAppointment());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseAppointmentDTO> updateAppointment(@PathVariable Long id, @RequestBody RequestAppointmentDTO requestAppointmentDTO) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, requestAppointmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.noContent().build();
    }
}