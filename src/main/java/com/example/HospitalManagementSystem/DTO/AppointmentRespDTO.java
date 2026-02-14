package com.example.HospitalManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AppointmentRespDTO {
    private long id;

    private LocalDate appointmentTime;

    private String reason;

    private DoctorReqDTO doctorReqDTO;
}
