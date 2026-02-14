package com.example.HospitalManagementSystem.DTO;


import com.example.HospitalManagementSystem.type.BloodGroupType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PatientRespDTO {
    private Long id;

    private String name;

    private String email;

    private LocalDate dob;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType blood;
}
