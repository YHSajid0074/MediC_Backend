package com.example.doctorAppointment.dto.request;

import jakarta.persistence.Column;

public record HospitalRequestDto(

        String hospitalName,

        String hospitalAddress,

        String hospitalContact
) {
}
