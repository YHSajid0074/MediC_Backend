package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.HealthMetricsRequestDto;
import com.example.doctorAppointment.model.healthMatrics.HealthMetrics;
import com.example.doctorAppointment.repository.healthMetricsRepo.HealthMetricsRepo;
import com.example.doctorAppointment.repository.userRepo.UserRepo;
import com.example.doctorAppointment.service.HealthMetricsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HealthMetricsServiceImpl implements HealthMetricsService {

    public HealthMetricsRepo healthMetricsRepo;
    public UserRepo userRepo;

    public HealthMetricsServiceImpl(HealthMetricsRepo healthMetricsRepo,UserRepo userRepo) {
        this.healthMetricsRepo = healthMetricsRepo;
        this.userRepo = userRepo;
    }

    public HealthMetrics convertToEntity(HealthMetricsRequestDto healthMetricsRequestDto,HealthMetrics healthMetrics) {
        healthMetrics.setMetricValue(healthMetricsRequestDto.metricValue());
        healthMetrics.setMetricType(healthMetricsRequestDto.metricType());
        healthMetrics.setUser(userRepo.findById(healthMetricsRequestDto.userId()).get());
        return healthMetrics;

    }


    @Override
    public void createHealthMetrics(HealthMetricsRequestDto healthMetricsRequestDto) {
        HealthMetrics healthMetrics = convertToEntity(healthMetricsRequestDto,new HealthMetrics());
        healthMetricsRepo.save(healthMetrics);
    }

    @Override
    public HealthMetrics getAllHealthMetrics() {
        return null;
    }

    @Override
    public void updateHealthMetrics(HealthMetricsRequestDto healthMetricsRequestDto,Long id) {

    }

    @Override
    public void deleteHealthMetrics() {

    }

    @Override
    public Set<HealthMetrics> getHealthMetricsById(Long id) {
        return Set.of();
    }
}
