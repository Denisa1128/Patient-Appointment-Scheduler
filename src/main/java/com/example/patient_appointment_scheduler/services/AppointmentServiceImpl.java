package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.exceptions.AppointmentNotFoundException;
import com.example.patient_appointment_scheduler.models.dtos.RequestAppointmentDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseAppointmentDTO;
import com.example.patient_appointment_scheduler.models.entities.Appointment;
import com.example.patient_appointment_scheduler.repositories.AppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
    private final ObjectMapper objectMapper;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(ObjectMapper objectMapper, AppointmentRepository appointmentRepository) {
        this.objectMapper = objectMapper;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseAppointmentDTO createAppointment(RequestAppointmentDTO requestAppointmentDTO) {
        Appointment appointmentEntity = objectMapper.convertValue(requestAppointmentDTO, Appointment.class);
        Appointment appointmentEntityResponse = appointmentRepository.save(appointmentEntity);
        log.info("Appointment with id {} was saved", appointmentEntityResponse.getId());

        return objectMapper.convertValue(appointmentEntityResponse, ResponseAppointmentDTO.class);
    }

    @Override
    public List<ResponseAppointmentDTO> getAppointment() {

        List<Appointment> appointmentDTOList = appointmentRepository.findAll();

        return appointmentDTOList.stream().map(appointment -> objectMapper.convertValue(appointment, ResponseAppointmentDTO.class)).toList();
    }

    @Override
    public ResponseAppointmentDTO updateAppointment(Long appointmentId, RequestAppointmentDTO requestAppointmentDTO) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found"));
        Appointment updatedAppointment = appointmentRepository.save(appointment);

        return objectMapper.convertValue(updatedAppointment, ResponseAppointmentDTO.class);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException("Appointment with id" + id + "not found"));
        appointmentRepository.deleteById(id);
        log.info("Medical Professional with id {} was deleted", id);
    }
}