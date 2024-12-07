package com.example.doctorAppointment.dto.response;

public interface AmbulanceResponseDto {

    String getAmbulanceNumber();

    String getDriverName();

    Long getDriverContact();

    Long getAvailabilityStatusId();

    String getCurrentLocation();

    Long getHospitalId();
}
