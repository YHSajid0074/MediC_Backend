package com.example.doctorAppointment.dto.request;

import com.example.doctorAppointment.model.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public record DoctorRequestDto(

        String speciality,

        String hospitalAffiliation,

        Integer experience_years,

        Double rating,

        String bio,

        Long userId
) {
}
