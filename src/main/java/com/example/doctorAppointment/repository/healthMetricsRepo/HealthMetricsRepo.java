package com.example.doctorAppointment.repository.healthMetricsRepo;

import com.example.doctorAppointment.model.healthMatrics.HealthMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthMetricsRepo extends JpaRepository<HealthMetrics, Long> {

    public List<HealthMetrics> findByPatientId(Long patientId);
}
