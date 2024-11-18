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

    // Patient details (User)
    UserInfo getPatient();

    // Nested interface for Doctor information
    interface DoctorInfo {
        String getSpeciality();
        Integer getExperience_years();
        Double getRating();
        String getBio();

        // Associated User details (specific fields only)
        DoctorUserInfo getUser();
    }

    // Nested interface for specific fields from Doctor's User
    interface DoctorUserInfo {
        String getUserName();
        String getEmail();
    }

    // Nested interface for User information (for patient)
    interface UserInfo {
        String getUserName();
        String getEmail();
        String getPhone();
        String getRole();
    }
}
