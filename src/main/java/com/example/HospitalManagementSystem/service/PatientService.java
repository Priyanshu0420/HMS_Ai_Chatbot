package com.example.HospitalManagementSystem.service;


import com.example.HospitalManagementSystem.DTO.PatientReqDTO;
import com.example.HospitalManagementSystem.DTO.PatientRespDTO;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientRespDTO getpatientbyid(Long id) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow();
        return modelMapper.map(patient, PatientRespDTO.class);
    }

    public PatientRespDTO findByName(String name) {
        Patient searchByName= patientRepository.findByName(name);
        return modelMapper.map(searchByName, PatientRespDTO.class);
    }

    public PatientRespDTO findByDob(LocalDate dob){
        Patient searchByDOB= patientRepository.findByDob(dob);
        return modelMapper.map(searchByDOB, PatientRespDTO.class);
    }

    public PatientRespDTO createPatient(PatientReqDTO patientReqDTO){
        Patient newPatient=modelMapper.map(patientReqDTO,Patient.class);
        Patient patient=patientRepository.save(newPatient);
        return modelMapper.map(patient,PatientRespDTO.class);
    }

    public List<PatientRespDTO> getAllPatients(){
        List<Patient> patientList= patientRepository.findAll();
        return patientList.stream().map(patients ->  modelMapper.map(patients,PatientRespDTO.class)).toList();
    }

    public void deletePatient(Long id){
        if (!patientRepository.existsById(id)) {
            throw  new EntityNotFoundException("Patient not found!");
        }
        patientRepository.deleteById(id);
    }

    public PatientRespDTO updatePatient(Long id, PatientReqDTO patientReqDTO){
        Patient patient=patientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Patient not found!"));
        modelMapper.map(patientReqDTO,patient);
        patient=patientRepository.save(patient);
        return modelMapper.map(patient,PatientRespDTO.class);
    }

    public PatientRespDTO modifyPatientDetails(Long id, PatientReqDTO patientReqDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found!! with id: " + id));

        if (patientReqDTO.getName() != null) {
            patient.setName(patientReqDTO.getName());
        }
        if (patientReqDTO.getEmail() != null) {
            patient.setEmail(patientReqDTO.getEmail());
        }
        if (patientReqDTO.getDob() != null) {
            patient.setDob(patientReqDTO.getDob());
        }
        if (patientReqDTO.getGender() != null) {
            patient.setGender(patientReqDTO.getGender());
        }
        if (patientReqDTO.getBlood() != null) {
            patient.setBlood(patientReqDTO.getBlood());
        }

        Patient updated = patientRepository.save(patient);

        return new PatientRespDTO(
                updated.getId(),
                updated.getName(),
                updated.getEmail(),
                updated.getDob(),
                updated.getGender(),
                updated.getBlood() );
    }

}

