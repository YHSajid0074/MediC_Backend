package com.example.doctorAppointment.model.appointment;


import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.user.CoreUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long appointmentId;

    @Column(nullable = false)
    public Date appointmentDate;

    @Column(nullable = false)
    public Time appointmentTime;

    public Status status;

   @ManyToOne
   @JoinColumn(name = "doctor_id", nullable = true)
   public Doctor doctor;

   @ManyToOne
   @JoinColumn(name = "user_id",nullable = true)
   public CoreUser coreUser;

    public Appointment() {
        this.appointmentDate = new Date(); // Sets the current date
        this.appointmentTime = new Time(System.currentTimeMillis()); // Sets the current time
    }

}
