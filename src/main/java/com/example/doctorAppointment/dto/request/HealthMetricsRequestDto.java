package com.example.doctorAppointment.dto.request;

import jakarta.persistence.Column;

public record HealthMetricsRequestDto(

        String metricType,

        Float metricValue,

        Long userId
) {
}
