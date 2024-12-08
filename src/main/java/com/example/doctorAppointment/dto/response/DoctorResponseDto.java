package com.example.doctorAppointment.dto.response;

import java.util.Set;

public interface DoctorResponseDto {

    String getSpeciality();

    String getHospitalAffiliation();

    Integer getExperience_years();

    Double getRating();

    String getBio();

    Set<Hospitals> getHospitals();

    interface Hospitals{

        String getHospitalName();

        String getHospitalAddress();

        String getHospitalContact();
    }

    User getUser();

    interface User{

        String getUserName();

        String getEmail();

        String getRole();

        String getPhone();

        String getAddress();

    }
}
