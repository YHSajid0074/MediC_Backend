package com.example.doctorAppointment.model.medicalRecord;

import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@Setter
@Getter
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long recordId;

    @Column(nullable = false)
    String diagnosis;

    @Column(nullable = false)
    String treatmentPlan;

    LocalDateTime createTime;

    @Column(nullable = false)
    String medications;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = true)
    Doctor doctor;

    public MedicalRecord() {
        this.createTime = LocalDateTime.now();  // Sets the current time
    }
}