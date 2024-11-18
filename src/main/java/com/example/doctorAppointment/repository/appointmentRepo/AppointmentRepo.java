package com.example.doctorAppointment.repository.appointmentRepo;


import com.example.doctorAppointment.model.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

}
