package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.response.AppointmentResponseDto;
import com.example.doctorAppointment.model.appointment.Appointment;
import com.example.doctorAppointment.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("Appointment")
public class AppointmentController {

    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("create/{userId}/{doctorId}")
    public ResponseEntity<String>create(@PathVariable Long userId,@PathVariable Long doctorId){
        appointmentService.createAppointment(userId,doctorId);
        return ResponseEntity.ok("Successfully created appointment");
    }

    @GetMapping("appointment/{appointmentId}")
    public  ResponseEntity<AppointmentResponseDto> getAppointmentByAppointmentId(@PathVariable Long appointmentId){
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }

    @GetMapping("doctor/{doctorId}")
    public ResponseEntity<Set<AppointmentResponseDto>> getAppointmentByDoctorId(@PathVariable Long doctorId){
        return ResponseEntity.ok(appointmentService.getAppointmentByDoctorId(doctorId));
    }

    @GetMapping("doctor/user/{doctorId}/{userId}")
    public ResponseEntity<Set<AppointmentResponseDto>> getAppointmentByDoctorIdAndUserId(@PathVariable Long doctorId,@PathVariable Long userId){
        return ResponseEntity.ok(appointmentService.getAppointmentByDoctorIdAndUserId(doctorId,userId));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<Set<AppointmentResponseDto>> getAppointmentByUserId(@PathVariable Long userId){

        return ResponseEntity.ok(appointmentService.getAppointmentByUserId(userId));
    }



//@GetMapping("name")
//    public String getUsernameFromSecurityContext() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName(); // This returns the username of the currently authenticated user
//    }



}
