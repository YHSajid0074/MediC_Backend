package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.response.AppointmentResponseDto;
import com.example.doctorAppointment.model.appointment.Appointment;

import java.util.List;
import java.util.Set;

public interface AppointmentService {

    public void createAppointment(Long doctorId, Long UserId);
    public AppointmentResponseDto getAppointmentById(Long id);
    public Set<AppointmentResponseDto> getAppointmentByDoctorId(Long doctorId);
    public Set<AppointmentResponseDto> getAppointmentByUserId(Long UserId);
    public Set<AppointmentResponseDto> getAppointmentByDoctorIdAndUserId(Long doctorId, Long UserId);

}
