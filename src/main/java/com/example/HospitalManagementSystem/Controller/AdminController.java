package com.example.HospitalManagementSystem.Controller;

import com.example.HospitalManagementSystem.DTO.DoctorRespDTO;
import com.example.HospitalManagementSystem.DTO.PatientRespDTO;
import com.example.HospitalManagementSystem.service.DoctorService;
import com.example.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientRespDTO>> retrieveAllPatients(){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
    }
    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorRespDTO>> retrieveAllDoctors(){
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllDoctors());
    }
}
