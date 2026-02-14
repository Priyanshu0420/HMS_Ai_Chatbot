package com.example.HospitalManagementSystem.Controller;


import com.example.HospitalManagementSystem.DTO.DoctorReqDTO;
import com.example.HospitalManagementSystem.DTO.DoctorRespDTO;
import com.example.HospitalManagementSystem.DTO.PatientReqDTO;
import com.example.HospitalManagementSystem.DTO.PatientRespDTO;
import com.example.HospitalManagementSystem.service.DoctorService;
import com.example.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    // Patient C-R-U-D Operations

    @PostMapping("/patients")
    public ResponseEntity<PatientRespDTO> createPatient(@PathVariable PatientReqDTO patientReqDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(patientReqDTO));
    }

    @GetMapping("/patients/{patientID}")
    public ResponseEntity<PatientRespDTO> searchPatient(@PathVariable Long patientID){
        return ResponseEntity.status(HttpStatus.FOUND).body(patientService.getpatientbyid(patientID));
    }

    @PutMapping("/patients/{patientID}")
    public ResponseEntity<PatientRespDTO> updatePatient(@PathVariable Long patientID,@PathVariable PatientReqDTO patientReqDTO){
        return ResponseEntity.status(HttpStatus.FOUND).body(patientService.updatePatient(patientID,patientReqDTO));
    }

    @DeleteMapping("/patients/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientID){
        patientService.deletePatient(patientID);
        return ResponseEntity.noContent().build();
    }


    // Doctor C-R-U-D Operations
    @PostMapping("/doctors")
    public ResponseEntity<DoctorRespDTO> createDoctor(@PathVariable DoctorReqDTO doctorReqDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.createDoctor(doctorReqDTO));
    }

    @GetMapping("/doctors/{doctorID}")
    public ResponseEntity<DoctorRespDTO> searchDoctor(@PathVariable Long doctorID){
        return ResponseEntity.status(HttpStatus.FOUND).body(doctorService.getdoctorById(doctorID));
    }

    @PutMapping("/doctors/{doctorID}")
    public ResponseEntity<DoctorRespDTO> updateDoctor(@PathVariable Long doctorID,@PathVariable DoctorReqDTO doctorReqDTO){
        return ResponseEntity.status(HttpStatus.FOUND).body(doctorService.updateDoctor(doctorID,doctorReqDTO));
    }

    @DeleteMapping("/doctors/{doctorID}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorID){
        doctorService.deleteDoctor(doctorID);
        return ResponseEntity.noContent().build();
    }



}
