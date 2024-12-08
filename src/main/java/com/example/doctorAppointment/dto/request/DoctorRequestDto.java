package com.example.doctorAppointment.dto.request;

public record DoctorRequestDto(

        String speciality,

        String hospitalAffiliation,

        Integer experience_years,

        Double rating,

        String bio,

        Long userId
) {
}
