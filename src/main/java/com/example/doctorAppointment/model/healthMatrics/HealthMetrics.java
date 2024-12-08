package com.example.doctorAppointment.model.healthMatrics;

import com.example.doctorAppointment.model.user.CoreUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class HealthMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long metricId;

    @Column(nullable = false)
    String metricType;

    @Column(nullable = false)
    Float metricValue;

    LocalDateTime recordTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    CoreUser coreUser;

    public HealthMetrics(){
        this.recordTime = LocalDateTime.now();
    }

}
