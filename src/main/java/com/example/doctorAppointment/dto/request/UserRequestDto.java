package com.example.doctorAppointment.dto.request;
import jakarta.persistence.Column;

public record UserRequestDto(

        String userName,

        String email,

        String password,

        String role,

        String phone,

        String address
) {
}
