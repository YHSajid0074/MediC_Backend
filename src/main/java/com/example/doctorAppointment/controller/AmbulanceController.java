package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.AmbulanceRequestDto;
import com.example.doctorAppointment.dto.response.AmbulanceResponseDto;
import com.example.doctorAppointment.model.ambulance.Ambulance;
import com.example.doctorAppointment.service.AmbulanceService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class AmbulanceController {

    AmbulanceService ambulanceService;

    public AmbulanceController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    @PostMapping("create")
    public ResponseEntity<String>CreateAmbulance(AmbulanceRequestDto ambulanceRequestDto) {

        ambulanceService.saveAmbulance(ambulanceRequestDto);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("All")
    public ResponseEntity<List<AmbulanceResponseDto>>GetAllAmbulances() {

        return ResponseEntity.ok(ambulanceService.getAllAmbulances());

    }

    @GetMapping("{id}")
    public ResponseEntity<AmbulanceResponseDto> getAmbulanceById(@PathVariable Long id) {

        return ResponseEntity.ok(ambulanceService.getAmbulanceById(id));

    }

    @GetMapping("{getAllByHospital}")
    public ResponseEntity<List<AmbulanceResponseDto>>getAmbulanceByHospitalId(@PathVariable Long hospitalId) {

        return ResponseEntity.ok(ambulanceService.getAmbulancesByHospital(hospitalId));
    }

    @GetMapping("{getAllByLocation}")
    public ResponseEntity<List<AmbulanceResponseDto>>getAmbulanceByLocation(@PathVariable String Location) {
        return ResponseEntity.ok(ambulanceService.getAmbulancesByLocation(Location));
    }

}
