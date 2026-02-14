package com.example.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;

    @ManyToMany(mappedBy = "doctors")
    @ToString.Exclude
    private List<Department> departmentLists;


}
