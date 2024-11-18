package com.example.doctorAppointment.model.hospital;

import com.example.doctorAppointment.model.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String hospitalName;

    @Column(nullable = false)
    String hospitalAddress;

    @Column(nullable = false)
    String hospitalContact;

    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "doctor_hospital",
            joinColumns = @JoinColumn( name = "hospitals_id" ),
            inverseJoinColumns = @JoinColumn( name = "doctors_id" )
    )

    Set<Doctor> doctors;

}
