package com.example.patient_appointment_scheduler.integration_tests;

import com.example.patient_appointment_scheduler.models.dtos.RequestPatientDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreatePatientShouldPass() throws Exception {
        RequestPatientDTO requestPatientDTO = new RequestPatientDTO();
        requestPatientDTO.setFirstName("Alice");
        requestPatientDTO.setLastName("David");
        requestPatientDTO.setPhone("0767586955");
        requestPatientDTO.setAge(30);
        requestPatientDTO.setEmail("aliced@gmail.com");
        requestPatientDTO.setAddress(" Timisoara ");

        mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestPatientDTO)))
                .andExpect(status().isOk());
    }
}