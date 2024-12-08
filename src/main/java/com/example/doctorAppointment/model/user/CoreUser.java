package com.example.doctorAppointment.model.user;
import com.example.doctorAppointment.model.appointment.Appointment;
import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.healthMatrics.HealthMetrics;
import com.example.doctorAppointment.model.medicalRecord.MedicalRecord;
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

public class CoreUser {
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

    @OneToOne(mappedBy = "coreUser")
    private Doctor doctor;

    @OneToMany(mappedBy = "coreUser")
    private Set<Appointment> appointment;

    @OneToMany(mappedBy = "coreUser")
    private Set<MedicalRecord>medicalRecords;

    @OneToMany(mappedBy = "coreUser")
    private Set<HealthMetrics> healthMetrics;
}
