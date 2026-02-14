package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Data
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private LocalDate dob;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType blood;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)        //Owning Side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE})
    private List<Appointment> appointment= new ArrayList<>();

}
