package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.AmbulanceRequestDto;
import com.example.doctorAppointment.dto.response.AmbulanceResponseDto;
import com.example.doctorAppointment.model.ambulance.Ambulance;
import com.example.doctorAppointment.model.ambulance.AvailabilityStatus;
import com.example.doctorAppointment.repository.ambulanceRepo.AmbulanceRepo;
import com.example.doctorAppointment.service.AmbulanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    AmbulanceRepo ambulanceRepo;

    public AmbulanceServiceImpl(AmbulanceRepo ambulanceRepo) {
        this.ambulanceRepo = ambulanceRepo;
    }

    public Ambulance convertToEntity(AmbulanceRequestDto ambulanceRequestDto,Ambulance ambulance) {

       ambulance.setDriverName(ambulanceRequestDto.driverName());
       ambulance.setAmbulanceNumber(ambulanceRequestDto.ambulanceNumber());
       ambulance.setDriverName(ambulanceRequestDto.driverName());
       ambulance.setAvailabilityStatus(AvailabilityStatus.findById(ambulanceRequestDto.availabilityStatusId()));

       return ambulance;
    }



    @Override
    public void saveAmbulance(AmbulanceRequestDto ambulanceRequestDto) {

      Ambulance ambulance = convertToEntity(ambulanceRequestDto,new Ambulance());

      ambulanceRepo.save(ambulance);
    }

    @Override
    public List<AmbulanceResponseDto> getAllAmbulances() {
        return ambulanceRepo.findAllAmbulance();
    }

    @Override
    public AmbulanceResponseDto getAmbulanceById(Long id) {
        return ambulanceRepo.findAmbulanceById(id);
    }

    @Override
    public void updateAmbulance(Long id, AmbulanceRequestDto updatedAmbulance) {

        Ambulance ambulance=ambulanceRepo.findById(id).get();
        Ambulance ambulance1= convertToEntity(updatedAmbulance,ambulance);

        ambulanceRepo.save(ambulance1);
    }

    @Override
    public void deleteAmbulance(Long id) {
     ambulanceRepo.deleteById(id);
    }

    @Override
    public List<AmbulanceResponseDto> getAvailableAmbulances(String status) {
        return ambulanceRepo.findAvailableAmbulance(status);
    }

    @Override
    public void updateAmbulanceStatus(Long id, AvailabilityStatus status) {
      Ambulance ambulance=ambulanceRepo.findById(id).get();
      ambulance.setAvailabilityStatus(status);
      ambulanceRepo.save(ambulance);
    }

    @Override
    public List<AmbulanceResponseDto> getAmbulancesByHospital(Long hospitalId) {
        List<AmbulanceResponseDto>ambulance= ambulanceRepo.findAmbulanceByHosptial(hospitalId);
        return ambulance;
    }

    @Override
    public List<AmbulanceResponseDto> getAmbulancesByLocation(String location) {
        List<AmbulanceResponseDto> ambulance= ambulanceRepo.findAmbulanceByLocation(location);
        return ambulance;
    }

    @Override
    public void assignAmbulanceToBooking(Long ambulanceId, Long bookingId) {

    }
}
