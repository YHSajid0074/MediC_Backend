package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.HealthMetricsRequestDto;
import com.example.doctorAppointment.service.HealthMetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("HealthMetrics")
public class HealthMetricsController {

    HealthMetricsService healthMetricsService;

    public HealthMetricsController(HealthMetricsService healthMetricsService) {
        this.healthMetricsService = healthMetricsService;
    }

    @PostMapping("/create")
    public ResponseEntity<String>createHealthMetrics(@RequestBody  HealthMetricsRequestDto healthMetricsRequestDto) {
        healthMetricsService.createHealthMetrics(healthMetricsRequestDto);
        return ResponseEntity.ok("Health Metrics Created");
    }

}
