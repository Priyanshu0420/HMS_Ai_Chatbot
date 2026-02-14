package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.DTO.AppointmentReqDTO;
import com.example.HospitalManagementSystem.DTO.AppointmentRespDTO;
import com.example.HospitalManagementSystem.entity.Appointment;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.AppointmentRepository;
import com.example.HospitalManagementSystem.repository.DoctorRepository;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentRespDTO createAppointment(AppointmentReqDTO AppointmentReqDTO) {
        Long doctorId = AppointmentReqDTO.getDoctorID();
        Long patientId = AppointmentReqDTO.getPatientID();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));
        Appointment appointment = Appointment.builder()
                .reason(AppointmentReqDTO.getReason())
                .appointmentTime(AppointmentReqDTO.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointment().add(appointment);

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentRespDTO.class);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointmentList().add(appointment);

        return appointment;
    }
    public List<AppointmentRespDTO> getAllAppointmentsOfDoctor(Long doctorID) {
        Doctor doctor = doctorRepository.findById(doctorID).orElseThrow();

        return doctor.getAppointmentList()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentRespDTO.class))
                .collect(Collectors.toList());
    }


}
