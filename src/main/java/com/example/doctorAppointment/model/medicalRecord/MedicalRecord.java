package com.example.doctorAppointment.model.medicalRecord;

import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.user.CoreUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    CoreUser coreUser;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = true)
    Doctor doctor;

    public MedicalRecord() {
        this.createTime = LocalDateTime.now();  // Sets the current time
    }
}
