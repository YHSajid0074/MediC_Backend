package com.example.doctorAppointment.model.appointment;


import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long AppointmentId;

    @Column(nullable = false)
    public Date AppointmentDate;

    @Column(nullable = false)
    public Time AppointmentTime;

    public Status status;

   @ManyToOne
   @JoinColumn(name = "doctor_id", nullable = true)
   public Doctor Doctor;

   @ManyToOne
   @JoinColumn(name = "user_id",nullable = true)
   public User user;
}
