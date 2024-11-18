package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Appointment")
public class AppointmentController {

    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("{userId}/{doctorId}")
    public ResponseEntity<String>create(@PathVariable Long userId,@PathVariable Long doctorId){
        appointmentService.createAppointment(userId,doctorId);
        return ResponseEntity.ok("Successfully created appointment");
    }
}
