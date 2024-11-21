package com.example.doctorAppointment.dto.response;

import java.time.LocalDateTime;

public interface MedicalRecordResponseDto {

    Long getRecordId();

    String getDiagnosis();

    String getTreatmentPlan();

    LocalDateTime getCreateTime();

    String getMedications();

    UserInfo getUser();

    interface UserInfo {

        String getUserName();

        String getEmail();

        String getRole();

        String getPhone();

        String getAddress();

    }

    DoctorInfo getDoctor();

    interface DoctorInfo {

        String getSpeciality();

        String getHospitalAffiliation();

        Integer getExperience_years();

        Double getRating();

        String getBio();

        DoctorUserInfo getUser();
    }
    interface DoctorUserInfo {

            String getUserName();

            String getEmail();
    }
}
