package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.DTO.AppointmentRespDTO;
import com.example.HospitalManagementSystem.DTO.DoctorReqDTO;
import com.example.HospitalManagementSystem.DTO.DoctorRespDTO;
import com.example.HospitalManagementSystem.DTO.PatientRespDTO;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.DoctorRepository;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public DoctorRespDTO createDoctor(DoctorReqDTO doctorReqDTO){
        Doctor newDoctor=modelMapper.map(doctorReqDTO,Doctor.class);
        Doctor dr=doctorRepository.save(newDoctor);
        return modelMapper.map(dr,DoctorRespDTO.class);
    }

    @Transactional
    public List<DoctorRespDTO> getAllDoctors(){
        List<Doctor> doctorsList= doctorRepository.findAll();
        return doctorsList.stream().map(patients ->  modelMapper.map(doctorsList,DoctorRespDTO.class)).toList();
    }

    @Transactional
    public DoctorRespDTO updateDoctorDetails(Long doctorID, DoctorReqDTO doctorReqDTO) {
        Doctor existingDoctor = doctorRepository.findById(doctorID)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found!"));

        if (doctorReqDTO.getName() != null) {
            existingDoctor.setName(doctorReqDTO.getName());
        }
        if (doctorReqDTO.getSpecialization() != null) {
            existingDoctor.setSpecialization(doctorReqDTO.getSpecialization());
        }
        if (doctorReqDTO.getEmail() != null) {
            existingDoctor.setEmail(doctorReqDTO.getEmail());
        }

        return new DoctorRespDTO(
                existingDoctor.getId(),
                existingDoctor.getName(),
                existingDoctor.getSpecialization(),
                existingDoctor.getEmail()
        );
    }

    @Transactional
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new EntityNotFoundException("Doctor not found!");
        }
        doctorRepository.deleteById(id);
    }

    @Transactional
    public DoctorRespDTO getdoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found!"));
        return modelMapper.map(doctor,DoctorRespDTO.class);
    }


    public DoctorRespDTO updateDoctor(Long doctorID, DoctorReqDTO doctorReqDTO) {
        Doctor existingDoctor = doctorRepository.findById(doctorID)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found!"));
        modelMapper.map(doctorReqDTO,existingDoctor);
        existingDoctor=doctorRepository.save(existingDoctor);
        return modelMapper.map(existingDoctor,DoctorRespDTO.class);
    }
}
