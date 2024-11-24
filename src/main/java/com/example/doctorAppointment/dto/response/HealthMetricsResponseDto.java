package com.example.doctorAppointment.dto.response;

import jakarta.persistence.Column;

public interface HealthMetricsResponseDto {
    String getMetricType();

    Float getMetricValue();

    UsersInfo getUser();

    interface UsersInfo {

        String getUserName();

        String getEmail();

        String getPhone();

        String getAddress();

    }
}
