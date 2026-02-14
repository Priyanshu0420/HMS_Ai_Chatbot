package com.example.HospitalManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AppointmentReqDTO {

    private Long patientID;

    private Long doctorID;

    private LocalDate appointmentTime;

    private String reason;
}
