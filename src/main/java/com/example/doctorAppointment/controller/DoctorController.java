package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.DoctorRequestDto;
import com.example.doctorAppointment.dto.response.DoctorResponseDto;
import com.example.doctorAppointment.model.doctor.Doctor;
import com.example.doctorAppointment.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {

    DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        doctorService.createDoctor(doctorRequestDto);
        return ResponseEntity.ok("Doctor added successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorResponseDto> getById(@PathVariable Long id) {
        DoctorResponseDto doctorResponseDto = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctorResponseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<DoctorResponseDto>> getAllDoctors(int page, int size, String sortBy, String sortOrder) {
        return ResponseEntity.ok(doctorService.getAllDoctors(page, size, sortBy, sortOrder));
    }

    @PatchMapping("update")
    public ResponseEntity<String> UpdateDoctor(@RequestBody DoctorRequestDto doctorRequestDto, @PathVariable Long id) {
        doctorService.updateDoctor(id, doctorRequestDto);
     return ResponseEntity.ok("Doctor updated successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    @GetMapping("hospital/{doctorId}")
    public ResponseEntity<Set<DoctorResponseDto.Hospitals>> getAllHospitalByDoctorId(@PathVariable Long doctorId) {
        return ResponseEntity.ok(doctorService.getHospitalsByDoctorId(doctorId));
    }
}
