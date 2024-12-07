package com.example.doctorAppointment.model.ambulance;

import com.example.doctorAppointment.model.hospital.Hospital;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ambulance {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @Column(unique = true, nullable = false)
    String ambulanceNumber ;

    @Column(unique = false, nullable = false)
    String driverName;

    @Column(unique = false, nullable = false)
    Long driverContact;

    @Column(unique = false, nullable = false)
    @Enumerated(EnumType.STRING)
    AvailabilityStatus availabilityStatus;

    @Column(name = "current_location")
    String currentLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    Hospital hospital;
}
