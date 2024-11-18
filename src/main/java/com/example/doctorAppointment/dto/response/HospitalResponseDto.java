package com.example.doctorAppointment.dto.response;

import com.example.doctorAppointment.model.doctor.Doctor;

import java.util.Set;

public interface HospitalResponseDto {

    String getHospitalName();

    String getHospitalAddress();

    String getHospitalContact();

    Set<Doctors> getDoctors();

    interface Doctors{

        String getSpeciality();

        String getHospitalAffiliation();

        Integer getExperience_years();

        Double getRating();

        String getBio();

        Users getUser();

        public interface Users {

            String getUserName();

            String getEmail();

            String getRole();

            String getPhone();

            String getAddress();
        }

    }

}
