package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.MedicalRecordRequestDto;
import com.example.doctorAppointment.dto.response.MedicalRecordResponseDto;
import com.example.doctorAppointment.service.MedicalRecordService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("MedicalRecord")
public class MedicalRecordController {

    MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createMedicalRecord(@RequestBody  MedicalRecordRequestDto medicalRecordRequestDto) {
        medicalRecordService.createMedicalRecord(medicalRecordRequestDto);
        return ResponseEntity.ok("Successfully created medical record");
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicalRecordResponseDto> getMedicalRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(medicalRecordService.getMedicalRecordById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedicalRecordById(@PathVariable Long id) {
        return ResponseEntity.ok("Successfully deleted record");
    }

    @PutMapping("update")
    public ResponseEntity<String> updateMedicalRecord(@RequestBody MedicalRecordRequestDto medicalRecordRequestDto,@PathVariable Long id) {
        return ResponseEntity.ok("Successfully updated record");
    }

    @GetMapping("getAll")
    public ResponseEntity<Set<MedicalRecordResponseDto>> getAllMedicalRecord() {
        return ResponseEntity.ok(medicalRecordService.getAllMedicalRecord());
    }

}
