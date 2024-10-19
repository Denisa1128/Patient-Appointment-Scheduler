package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.models.dtos.RequestAppointmentDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseAppointmentDTO;

import java.util.List;

public interface AppointmentService {

    ResponseAppointmentDTO createAppointment(RequestAppointmentDTO responseAppointmentDTO);

    void deleteAppointmentById(Long id);

    List<ResponseAppointmentDTO> getAppointment();

    ResponseAppointmentDTO updateAppointment(Long id, RequestAppointmentDTO responseAppointmentDTO);


}


