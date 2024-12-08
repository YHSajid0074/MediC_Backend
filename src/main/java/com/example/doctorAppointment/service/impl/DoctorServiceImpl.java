package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.DoctorRequestDto;
import com.example.doctorAppointment.dto.response.DoctorResponseDto;
import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.repository.doctorRepo.DoctorRepo;
import com.example.doctorAppointment.repository.userRepo.UserRepo;
import com.example.doctorAppointment.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

    DoctorRepo doctorRepo;
    UserRepo userRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo, UserRepo userRepo) {
        this.doctorRepo = doctorRepo;
        this.userRepo = userRepo;
    }

    public Doctor convertToEntity(DoctorRequestDto doctorRequestDto,Doctor doctor) {

        doctor.setSpeciality(doctorRequestDto.speciality());
        doctor.setBio(doctorRequestDto.bio());
        doctor.setHospitalAffiliation(doctorRequestDto.hospitalAffiliation());
        doctor.setExperience_years(doctorRequestDto.experience_years());
        doctor.setRating(doctorRequestDto.rating());
        doctor.setCoreUser(userRepo.findById(doctorRequestDto.userId()).get());

        return doctor;
    }


    @Override
    public void createDoctor(DoctorRequestDto doctorRequestDto) {
     Doctor doctor = convertToEntity(doctorRequestDto,new Doctor());
     doctorRepo.save(doctor);
    }

    @Override
    public DoctorResponseDto getDoctorById(Long id) {
        return doctorRepo.findDoctorById(id);
    }

    @Override
    public Page<DoctorResponseDto> getAllDoctors(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
       return doctorRepo.findAllDoctor(pageable);
    }

    @Override
    public void updateDoctor(Long id, DoctorRequestDto doctorRequestDto) {
        Doctor doctor=doctorRepo.findById(id).get();
        Doctor doctor1 = convertToEntity(doctorRequestDto,doctor);
        doctorRepo.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
      doctorRepo.deleteById(id);
    }

    @Override
    public Set<DoctorResponseDto.Hospitals> getHospitalsByDoctorId(Long id) {
        DoctorResponseDto doctorResponseDto=doctorRepo.findDoctorById(id);
        return doctorResponseDto.getHospitals();
    }
}
