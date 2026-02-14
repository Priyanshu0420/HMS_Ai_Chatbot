package com.example.HospitalManagementSystem.Controller;

import com.example.HospitalManagementSystem.DTO.*;
import com.example.HospitalManagementSystem.service.AppointmentService;
import com.example.HospitalManagementSystem.service.InsuranceService;
import com.example.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final InsuranceService insuranceService;

    @GetMapping("/{patientID}/profile")
    public ResponseEntity<PatientRespDTO> profile(@PathVariable Long patientID){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getpatientbyid(patientID));
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentRespDTO> newAppointment(@RequestBody AppointmentReqDTO appointmentReqDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createAppointment(appointmentReqDTO));
    }

    @PostMapping("/{patientID}/insurances")
    public ResponseEntity<InsuranceRespDTO> newInsurance(@RequestBody InsuranceReqDTO insuranceReqDTO , @PathVariable Long patientID){
        return ResponseEntity.status(HttpStatus.CREATED).body(insuranceService.assignInsurance(insuranceReqDTO,patientID));
    }

    @PatchMapping("/{patientID}/update")
    public ResponseEntity<PatientRespDTO> updateDetails(@RequestBody PatientReqDTO patientReqDTO,@PathVariable Long patientID){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.modifyPatientDetails(patientID, patientReqDTO));
    }
}
