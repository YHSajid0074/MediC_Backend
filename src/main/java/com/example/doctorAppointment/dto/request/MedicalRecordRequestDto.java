package com.example.doctorAppointment.dto.request;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public record MedicalRecordRequestDto(

        String diagnosis,

        String treatmentPlan,

        String medications,

        Long userId,

        Long doctorId

)
{
}
