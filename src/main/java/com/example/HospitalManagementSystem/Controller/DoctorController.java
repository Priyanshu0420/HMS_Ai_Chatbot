package com.example.HospitalManagementSystem.Controller;

import com.example.HospitalManagementSystem.DTO.AppointmentRespDTO;
import com.example.HospitalManagementSystem.DTO.DoctorReqDTO;
import com.example.HospitalManagementSystem.DTO.DoctorRespDTO;
import com.example.HospitalManagementSystem.service.AppointmentService;
import com.example.HospitalManagementSystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;


    @GetMapping("/{doctorID}/profile")
    public ResponseEntity<DoctorRespDTO> profile(@PathVariable Long doctorID){
       return ResponseEntity.status(HttpStatus.OK).body(doctorService.getdoctorById(doctorID));
    }

    @GetMapping("/{doctorID}/appointments")
    public ResponseEntity<List<AppointmentRespDTO>> scheduledAppointments(@PathVariable Long doctorID){
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAllAppointmentsOfDoctor(doctorID));
    }

    @PatchMapping("/{doctorID}/update")
    public ResponseEntity<DoctorRespDTO> updateDetails(@PathVariable Long doctorID, @RequestBody DoctorReqDTO doctorReqDTO){
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.updateDoctorDetails(doctorID,doctorReqDTO));
    }
}
