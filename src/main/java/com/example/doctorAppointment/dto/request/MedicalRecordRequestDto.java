package com.example.doctorAppointment.dto.request;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public record MedicalRecordRequestDto(

        Long recordId,

        String diagnosis,

        String treatmentPlan,

        LocalDateTime createTime,

        String medications,

        Long userId,

        Long doctorId

)
{
}
