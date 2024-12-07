package com.example.doctorAppointment.dto.request;

import jakarta.persistence.*;

public record AmbulanceRequestDto(

        String ambulanceNumber,

        String driverName,

        Long driverContact,

        Long availabilityStatusId,

        String currentLocation,

        Long hospitalId
) {
}
