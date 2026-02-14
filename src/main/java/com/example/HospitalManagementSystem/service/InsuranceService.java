package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.DTO.InsuranceReqDTO;
import com.example.HospitalManagementSystem.DTO.InsuranceRespDTO;
import com.example.HospitalManagementSystem.entity.Insurance;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.InsuranceRepository;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public InsuranceRespDTO assignInsurance(InsuranceReqDTO insuranceReqDTO, Long patientID) {

        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientID));

        Insurance insurance = modelMapper.map(insuranceReqDTO, Insurance.class);

        insurance.setPatient(patient);
        patient.setInsurance(insurance);

        Insurance savedInsurance = insuranceRepository.save(insurance);

        InsuranceRespDTO responseDTO = modelMapper.map(savedInsurance, InsuranceRespDTO.class);
        responseDTO.setPatientID(patient.getId());
//        responseDTO.setPatientName(patient.getName());

        return responseDTO;
    }

    @Transactional
    public InsuranceRespDTO removeInsurance(Long patientID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientID));

        Insurance insurance = patient.getInsurance();
        if (insurance == null) {
            throw new IllegalStateException("Patient does not have insurance assigned.");
        }
        patient.setInsurance(null);
        insurance.setPatient(null);

        insuranceRepository.delete(insurance);

        InsuranceRespDTO responseDTO = modelMapper.map(insurance, InsuranceRespDTO.class);
        responseDTO.setPatientID(patient.getId());
//        responseDTO.setPatientName(patient.getName());

        return responseDTO;
    }
}
