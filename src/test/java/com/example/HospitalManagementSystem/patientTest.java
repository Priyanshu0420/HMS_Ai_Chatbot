import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;//package com.example.HospitalManagementSystem;

import java.util.List;
//
//import com.example.HospitalManagementSystem.entity.Patient;
//import com.example.HospitalManagementSystem.repository.PatientRepository;
//import com.example.HospitalManagementSystem.service.PatientService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import java.util.List;
//
//@SpringBootTest
//public class patientTest {
//
//    @Autowired
//    private PatientRepository patientRepository;
//    private PatientService patientService;
//
//    @Test
//    public void testpatientRepo(){
//        List<Patient> patientList=patientRepository.findAll();
//        System.out.println(patientList);
//
//        Patient p1=new Patient();
//        patientRepository.save(p1);
//
//
//    }
//
//    @Test
//    public void patientbyname(){
//        Patient p=patientService.findByName("Diya");
//        System.out.println(p);
//
//    }
//
//    @Test
//    public void patientbyemailorname(){
//        PatientRepository patientRepository;
//        List<Patient> patientList=patientRepository.findByEmailOrName("rdpriyanshuthakur@gmail.com","Shateesh");
//        System.out.println(patientList);
//    }
////}
