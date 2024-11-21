package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.response.AppointmentResponseDto;
import com.example.doctorAppointment.model.appointment.Appointment;
import com.example.doctorAppointment.model.appointment.Status;
import com.example.doctorAppointment.repository.appointmentRepo.AppointmentRepo;
import com.example.doctorAppointment.repository.doctorRepo.DoctorRepo;
import com.example.doctorAppointment.repository.userRepo.UserRepo;
import com.example.doctorAppointment.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    public AppointmentRepo appointmentRepo;
    public UserRepo userRepo;
    public DoctorRepo doctorRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo, UserRepo userRepo, DoctorRepo doctorRepo) {
        this.appointmentRepo = appointmentRepo;
        this.userRepo = userRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createAppointment(Long UserId, Long doctorId) {

        Appointment appointment = new Appointment();
        appointment.setUser(userRepo.findById(UserId).get());
        appointment.setDoctor(doctorRepo.findById(doctorId).get());
        appointment.setStatus(Status.SCHEDULED);

        appointmentRepo.save(appointment);
    }

    @Override
    public AppointmentResponseDto getAppointmentById(Long id) {
        return appointmentRepo.findAppointmentById(id);
    }

    @Override
    public Set<AppointmentResponseDto> getAppointmentByDoctorId(Long doctorId) {
        return appointmentRepo.findAppointmentByDoctorId(doctorId);
    }

    @Override
    public Set<AppointmentResponseDto> getAppointmentByUserId(Long UserId) {
        return appointmentRepo.findAppointmentsByUserId(UserId);
    }

    @Override
    public Set<AppointmentResponseDto> getAppointmentByDoctorIdAndUserId(Long doctorId, Long UserId) {
        return appointmentRepo.findAppointmentsByDoctorIdAndUserId(doctorId, UserId);
    }
}
