package com.example.doctorAppointment.dto.response;

import com.example.doctorAppointment.model.appointment.Status;
import java.sql.Time;
import java.util.Date;

public interface AppointmentResponseDto {

    // Appointment-level details
    Date getAppointmentDate();
    Time getAppointmentTime();
    Status getStatus();

    // Doctor details
    DoctorInfo getDoctor();

    // Patient details (CoreUser)
    UserInfo getUser();

    // Nested interface for Doctor information
    interface DoctorInfo {
        String getSpeciality();
        Integer getExperience_years();
        Double getRating();
        String getBio();

        // Associated CoreUser details (specific fields only)
        DoctorUserInfo getUser();
    }

    // Nested interface for specific fields from Doctor's CoreUser
    interface DoctorUserInfo {
        String getUserName();
        String getEmail();
    }

    // Nested interface for CoreUser information (for patient)
    interface UserInfo {
        String getUserName();
        String getEmail();
        String getPhone();
        String getRole();
    }
}
