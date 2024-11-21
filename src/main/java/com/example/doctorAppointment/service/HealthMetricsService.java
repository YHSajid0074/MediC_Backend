package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.HealthMetricsRequestDto;
import com.example.doctorAppointment.model.healthMatrics.HealthMetrics;

import java.util.Set;

public interface HealthMetricsService {

    public void createHealthMetrics(HealthMetricsRequestDto healthMetricsRequestDto);
    public HealthMetrics getAllHealthMetrics();
    public void updateHealthMetrics(HealthMetricsRequestDto healthMetricsRequestDto,Long id);
    public void deleteHealthMetrics();
    public Set<HealthMetrics> getHealthMetricsById(Long id);

}
