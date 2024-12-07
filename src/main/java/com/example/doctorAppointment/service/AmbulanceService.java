package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.AmbulanceRequestDto;
import com.example.doctorAppointment.dto.response.AmbulanceResponseDto;
import com.example.doctorAppointment.model.ambulance.Ambulance;
import com.example.doctorAppointment.model.ambulance.AvailabilityStatus;

import java.util.List;

public interface AmbulanceService {

        void saveAmbulance(AmbulanceRequestDto ambulanceRequestDto);

        List<AmbulanceResponseDto> getAllAmbulances();

        AmbulanceResponseDto getAmbulanceById(Long id);

        void updateAmbulance(Long id, AmbulanceRequestDto updatedAmbulance);

        void deleteAmbulance(Long id);

        List<AmbulanceResponseDto> getAvailableAmbulances(String status);

        void updateAmbulanceStatus(Long id, AvailabilityStatus status);

        List<AmbulanceResponseDto> getAmbulancesByHospital(Long hospitalId);

        List<AmbulanceResponseDto> getAmbulancesByLocation(String location);

        void assignAmbulanceToBooking(Long ambulanceId, Long bookingId);


}
