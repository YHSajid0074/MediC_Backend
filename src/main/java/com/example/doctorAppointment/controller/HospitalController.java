package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.HospitalRequestDto;
import com.example.doctorAppointment.dto.response.HospitalResponseDto;
import com.example.doctorAppointment.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("Hospital")
public class HospitalController {

    HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("{id}")
    public ResponseEntity<HospitalResponseDto> getById(@PathVariable Long id){

            HospitalResponseDto hospitalResponseDto=hospitalService.getHospitalById(id);

            return ResponseEntity.ok(hospitalResponseDto);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<HospitalResponseDto>> getAllHospital(){

        return ResponseEntity.ok(hospitalService.getAllHospitals());

    }

    @PostMapping("create")
    public ResponseEntity<String> createHospital(@RequestBody HospitalRequestDto hospitalRequestDto){

         hospitalService.addHospital(hospitalRequestDto);

         return ResponseEntity.ok("Hospital created");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteHospital(@PathVariable Long id){

        hospitalService.deleteHospital(id);

        return ResponseEntity.ok("Hospital deleted");
    }

    @PatchMapping("update")
    public ResponseEntity<String> updateHospital(@RequestBody HospitalRequestDto hospitalRequestDto,@PathVariable Long id){

        hospitalService.updateHospital(hospitalRequestDto,id);

        return ResponseEntity.ok("Hospital updated");
    }

    @PostMapping("{hospitalId}/{doctorId}")
    public ResponseEntity<String> assignDoctor(
            @PathVariable Long hospitalId,
            @PathVariable Long doctorId){
       hospitalService.assignDoctor(hospitalId,doctorId);
       return ResponseEntity.ok("Doctor assigned");
    }


    @GetMapping("doctors/{id}")
    public ResponseEntity<Set<HospitalResponseDto.Doctors>>getDoctorsByHospital(Long hospitalId){
        return ResponseEntity.ok(hospitalService.getAllDoctorsByHospitalId(hospitalId));
    }

}
