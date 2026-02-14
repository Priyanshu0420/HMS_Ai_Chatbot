package com.example.HospitalManagementSystem.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DoctorReqDTO {
    private String name;

    private String specialization;

    @Column(nullable = false,unique = true)
    private String email;
}
