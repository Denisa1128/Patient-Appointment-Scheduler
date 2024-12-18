package com.example.patient_appointment_scheduler.services;

import com.example.patient_appointment_scheduler.exceptions.AppointmentNotFoundException;
import com.example.patient_appointment_scheduler.exceptions.MedicalProfessionalNotFoundException;
import com.example.patient_appointment_scheduler.exceptions.PatientNotFoundException;
import com.example.patient_appointment_scheduler.models.dtos.RequestAppointmentDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseAppointmentDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponseMedicalProfessionalDTO;
import com.example.patient_appointment_scheduler.models.dtos.ResponsePatientDTO;
import com.example.patient_appointment_scheduler.models.entities.Appointment;
import com.example.patient_appointment_scheduler.models.entities.MedicalProfessional;
import com.example.patient_appointment_scheduler.models.entities.Patient;
import com.example.patient_appointment_scheduler.repositories.AppointmentRepository;
import com.example.patient_appointment_scheduler.repositories.MedicalProfessionalRepository;
import com.example.patient_appointment_scheduler.repositories.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
    private final ObjectMapper objectMapper;
    private final AppointmentRepository appointmentRepository;
    private final MedicalProfessionalRepository medicalProfessionRepository;
    private final PatientRepository patientRepository;


    public AppointmentServiceImpl(ObjectMapper objectMapper, AppointmentRepository appointmentRepository,
                                  MedicalProfessionalRepository medicalProfessionRepository,
                                  PatientRepository patientRepository) {
        this.objectMapper = objectMapper;
        this.patientRepository = patientRepository;
        this.medicalProfessionRepository = medicalProfessionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseAppointmentDTO createAppointment(RequestAppointmentDTO requestAppointmentDTO) {
        Patient patient = patientRepository.findById(requestAppointmentDTO.getPatientId()).orElseThrow(() -> new PatientNotFoundException("Patient with the id" + requestAppointmentDTO.getPatientId() + "not found"));
        MedicalProfessional medicalProfessional = medicalProfessionRepository.findById(requestAppointmentDTO.getProfessionalId()).orElseThrow(() -> new MedicalProfessionalNotFoundException("Medical with the id" + requestAppointmentDTO.getProfessionalId() + "not found"));

        Appointment appointmentEntity = new Appointment();
        appointmentEntity.setPatient(patient);
        appointmentEntity.setMedicalProfessional(medicalProfessional);
        appointmentEntity.setAppointmentDateTime(LocalDateTime.now());
        appointmentEntity.setStatus(requestAppointmentDTO.getStatus());
        appointmentEntity.setTreatmentDetails(requestAppointmentDTO.getTreatmentDetails());

        Appointment entityResponse = appointmentRepository.save(appointmentEntity);
        log.info("Appointment with id {} was saved", entityResponse.getId());

        ResponseAppointmentDTO response = new ResponseAppointmentDTO();
        response.setId(entityResponse.getId());
        response.setPatient(objectMapper.convertValue(entityResponse.getPatient(), ResponsePatientDTO.class));
        response.setMedicalProfessional(objectMapper.convertValue(entityResponse.getMedicalProfessional(), ResponseMedicalProfessionalDTO.class));
        response.setStatus(entityResponse.getStatus());
        response.setAppointmentDateTime(entityResponse.getAppointmentDateTime());
        response.setTreatmentDetails(entityResponse.getTreatmentDetails());

        return response;
    }

    @Override
    public List<ResponseAppointmentDTO> getAppointment() {

        List<Appointment> appointmentDTOList = appointmentRepository.findAll();

        return appointmentDTOList.stream().map(appointment -> objectMapper.convertValue(appointment, ResponseAppointmentDTO.class)).toList();
    }

    @Override
    @Transactional
    public ResponseAppointmentDTO updateAppointment(Long appointmentId, RequestAppointmentDTO requestAppointmentDTO) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found"));
        appointment.setStatus(requestAppointmentDTO.getStatus());
        appointment.setTreatmentDetails(requestAppointmentDTO.getTreatmentDetails());
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