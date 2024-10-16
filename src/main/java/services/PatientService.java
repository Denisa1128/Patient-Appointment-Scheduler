package services;

import models.dtos.RequestPatientDTO;
import models.dtos.ResponsePatientDTO;

import java.util.List;

public interface PatientService {

    ResponsePatientDTO createPatient(RequestPatientDTO requestPatientDTO);
}
