package com.example.doctorAppointment.service.impl;

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
    public void createAppointment(Long doctorId, Long UserId) {
        Appointment appointment = new Appointment();
        appointment.setUser(userRepo.findById(UserId).get());
        appointment.setDoctor(doctorRepo.findById(doctorId).get());
        appointment.setStatus(Status.SCHEDULED);
        appointmentRepo.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepo.findById(id).get();
    }

    @Override
    public Set<Appointment> getAppointmentByDoctorId(Long doctorId) {
        return Set.of();
    }

    @Override
    public Set<Appointment> getAppointmentByUserId(Long UserId) {
        return Set.of();
    }

    @Override
    public Set<Appointment> getAppointmentByDoctorIdAndUserId(Long doctorId, Long UserId) {
        return Set.of();
    }
}
