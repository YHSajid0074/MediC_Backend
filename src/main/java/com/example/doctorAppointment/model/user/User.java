package com.example.doctorAppointment.model.user;
import com.example.doctorAppointment.model.appointment.Appointment;
import com.example.doctorAppointment.model.doctor.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long userId;

    @Column(nullable = false)
    String userName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String role;

    @Column(nullable = false)
    String phone;

    String address;

    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    @OneToMany(mappedBy = "appointment")
    private Set<Appointment> appointment;
}
