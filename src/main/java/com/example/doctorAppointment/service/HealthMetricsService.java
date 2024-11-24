package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.HealthMetricsRequestDto;
import com.example.doctorAppointment.dto.response.HealthMetricsResponseDto;
import com.example.doctorAppointment.model.healthMatrics.HealthMetrics;

import java.util.Set;

public interface HealthMetricsService {

    public void createHealthMetrics(HealthMetricsRequestDto healthMetricsRequestDto);
    public Set<HealthMetricsResponseDto> getAllHealthMetrics();
    public void updateHealthMetrics(HealthMetricsRequestDto healthMetricsRequestDto,Long id);
    public void deleteHealthMetrics();
    public HealthMetricsResponseDto getHealthMetricsById(Long id);

}
