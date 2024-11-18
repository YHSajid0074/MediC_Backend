package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.HospitalRequestDto;
import com.example.doctorAppointment.dto.response.DoctorResponseDto;
import com.example.doctorAppointment.dto.response.HospitalResponseDto;
import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.hospital.Hospital;
import com.example.doctorAppointment.repository.doctorRepo.DoctorRepo;
import com.example.doctorAppointment.repository.hospitalRepo.HospitalRepo;
import com.example.doctorAppointment.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HospitalServiceImpl implements HospitalService {


    HospitalRepo hospitalRepo;
    DoctorRepo doctorRepo;

    HospitalServiceImpl(HospitalRepo hospitalRepo, DoctorRepo doctorRepo) {
        this.hospitalRepo=hospitalRepo;
        this.doctorRepo=doctorRepo;
    }


    public Hospital convertToEntity(HospitalRequestDto hospitalRequestDto,Hospital hospital) {

        hospital.setHospitalAddress(hospitalRequestDto.hospitalAddress());
        hospital.setHospitalName(hospitalRequestDto.hospitalName());
        hospital.setHospitalContact(hospitalRequestDto.hospitalContact());

        return hospital;
    }

    @Override
    public HospitalResponseDto getHospitalById(Long hospitalId) {
        return hospitalRepo.findHospitalById(hospitalId);
    }

    @Override
    public List<HospitalResponseDto> getAllHospitals() {
        return hospitalRepo.findAllHospitals();
    }

    @Override
    public void addHospital(HospitalRequestDto hospitalRequestDto) {
     Hospital hospital = convertToEntity(hospitalRequestDto,new Hospital());
     hospitalRepo.save(hospital);
    }

    @Override
    public void updateHospital(HospitalRequestDto hospitalRequestDto, Long hospitalId) {

       Hospital hospital = hospitalRepo.findById(hospitalId).get();
       Hospital hospitalUpdate = convertToEntity(hospitalRequestDto,hospital);
       hospitalRepo.save(hospitalUpdate);

    }

    @Override
    public void deleteHospital(Long hospitalId) {
        hospitalRepo.deleteById(hospitalId);
    }

    @Override
    public void assignDoctor(Long HospitalId, Long DoctorId) {

       Doctor doctor = doctorRepo.findById(DoctorId).get();
       Hospital hospital = hospitalRepo.findById(HospitalId).get();
        Set<Doctor> doctors = hospital.getDoctors();
        doctors.add(doctor);
        hospital.setDoctors(doctors);

        hospitalRepo.save(hospital);
    }

    @Override
    public List<HospitalResponseDto> getHospitalByName(String doctorName) {
        return List.of();
    }

    @Override
    public Set<HospitalResponseDto.Doctors> getAllDoctorsByHospitalId(Long hospitalId) {

        HospitalResponseDto hospitalResponseDto = hospitalRepo.findHospitalById(hospitalId);

       return hospitalResponseDto.getDoctors();

    }
}
