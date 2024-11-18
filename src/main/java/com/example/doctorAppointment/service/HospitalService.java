package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.DoctorRequestDto;
import com.example.doctorAppointment.dto.request.HospitalRequestDto;
import com.example.doctorAppointment.dto.response.DoctorResponseDto;
import com.example.doctorAppointment.dto.response.HospitalResponseDto;
import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.model.hospital.Hospital;

import java.util.List;
import java.util.Set;

public interface HospitalService {


public HospitalResponseDto getHospitalById(Long hospitalId);
public List<HospitalResponseDto> getAllHospitals();
public void addHospital(HospitalRequestDto hospitalRequestDto);
public void updateHospital(HospitalRequestDto hospitalRequestDto,Long hospitalId);
public void deleteHospital(Long hospitalId);
public void assignDoctor(Long HospitalId,Long DoctorId);
public HospitalResponseDto  getHospitalByName(String doctorName);
public Set<HospitalResponseDto.Doctors> getAllDoctorsByHospitalId(Long hospitalId);


}
