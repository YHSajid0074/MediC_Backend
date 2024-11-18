package com.example.doctorAppointment.model.doctor;

import com.example.doctorAppointment.model.appointment.Appointment;
import com.example.doctorAppointment.model.hospital.Hospital;
import com.example.doctorAppointment.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long doctorId;

    @Column(nullable = false)
    String speciality;

    @Column(nullable = false)
    String hospitalAffiliation;

    @Column(nullable = false)
    Integer experience_years;

    @Column(nullable = false)
    Double rating;

    @Column(nullable = true)
    String bio;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "doctors" // Refers to the "doctors" field in Hospital
    )

    private Set<Hospital> hospitals;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointment;

}
