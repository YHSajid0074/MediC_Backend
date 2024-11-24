package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.HealthMetricsRequestDto;
import com.example.doctorAppointment.dto.response.HealthMetricsResponseDto;
import com.example.doctorAppointment.service.HealthMetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PutMapping("update/{id}")
    public ResponseEntity<String>updateHealthMetrics(@RequestBody  HealthMetricsRequestDto healthMetricsRequestDto,@PathVariable Long id) {
        healthMetricsService.updateHealthMetrics(healthMetricsRequestDto,id);
        return ResponseEntity.ok("Health Metrics Updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteHealthMetrics(@PathVariable Long id) {
        healthMetricsService.deleteHealthMetrics();
        return ResponseEntity.ok("Health Metrics Deleted");
    }

    @GetMapping("all")
    public ResponseEntity<Set<HealthMetricsResponseDto>> getAllHealthMetrics() {
        return ResponseEntity.ok(healthMetricsService.getAllHealthMetrics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthMetricsResponseDto> getHealthMetricsById(@PathVariable Long id) {
     return ResponseEntity.ok(healthMetricsService.getHealthMetricsById(id));
    }

}
