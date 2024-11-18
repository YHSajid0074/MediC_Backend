package com.example.doctorAppointment.service;

import com.example.doctorAppointment.model.appointment.Appointment;

import java.util.List;
import java.util.Set;

public interface AppointmentService {

    public void createAppointment(Long doctorId, Long UserId);
    public Appointment getAppointmentById(Long id);
    public Set<Appointment> getAppointmentByDoctorId(Long doctorId);
    public Set<Appointment> getAppointmentByUserId(Long UserId);
    public Set<Appointment> getAppointmentByDoctorIdAndUserId(Long doctorId, Long UserId);

}
