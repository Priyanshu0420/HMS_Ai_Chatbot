package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);

    Patient findByDob(LocalDate dob);

    List<Patient> findByEmailOrName(String email, String name);

    List<Patient> findByBlood(BloodGroupType blood);
}

