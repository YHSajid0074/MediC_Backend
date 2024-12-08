package com.example.doctorAppointment.repository.appointmentRepo;

import com.example.doctorAppointment.dto.response.AppointmentResponseDto;
import com.example.doctorAppointment.model.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

    @Query("""
            SELECT a FROM Appointment a
            WHERE a.appointmentId = :id
            """)
    AppointmentResponseDto findAppointmentById(Long id);

    @Query("""
            SELECT a FROM Appointment a
            WHERE a.doctor.doctorId=:doctorId
            """)
    Set<AppointmentResponseDto> findAppointmentByDoctorId(Long doctorId);


    @Query("""
            SELECT a FROM Appointment a
                where  a.coreUser.userId=:userId
            """)
    Set<AppointmentResponseDto> findAppointmentsByUserId(Long userId);


    @Query("""
            SELECT a FROM Appointment a
            WHERE a.doctor.doctorId=:doctorId
            and a.coreUser.userId=:userId
            """)
    Set<AppointmentResponseDto> findAppointmentsByDoctorIdAndUserId(Long doctorId, Long userId);

}
