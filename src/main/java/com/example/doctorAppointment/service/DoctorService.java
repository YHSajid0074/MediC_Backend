package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.DoctorRequestDto;
import com.example.doctorAppointment.dto.response.DoctorResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    public void createDoctor(DoctorRequestDto doctorRequestDto);
    public DoctorResponseDto getDoctorById(Long id);
    public Page<DoctorResponseDto> getAllDoctors(int page, int size, String sortBy, String sortOrder);
    public void updateDoctor(Long id, DoctorRequestDto doctorRequestDto);
    public void deleteDoctor(Long id);
    public Set<DoctorResponseDto.Hospitals>getHospitalsByDoctorId(Long id);

}
