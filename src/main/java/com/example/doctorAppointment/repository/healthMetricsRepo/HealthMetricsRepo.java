package com.example.doctorAppointment.repository.healthMetricsRepo;

import com.example.doctorAppointment.dto.response.HealthMetricsResponseDto;
import com.example.doctorAppointment.model.healthMatrics.HealthMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface HealthMetricsRepo extends JpaRepository<HealthMetrics, Long> {

    @Query("""
       Select hm
       From HealthMetrics hm
       Where hm.metricId=:id
""")
    public HealthMetricsResponseDto getHealthMetricsById(Long id);


    @Query("""
        Select hm
        FROM HealthMetrics hm
""")
    public Set<HealthMetricsResponseDto> getAllHealthMetrics();


}
