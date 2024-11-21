package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.MedicalRecordRequestDto;
import com.example.doctorAppointment.dto.response.MedicalRecordResponseDto;
import com.example.doctorAppointment.model.medicalRecord.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {

    public void createMedicalRecord(MedicalRecordRequestDto medicalRecordRequestDto);
    public List<MedicalRecordResponseDto> getAllMedicalRecord();
    public MedicalRecordResponseDto getMedicalRecordById(Long id);
    public void updateMedicalRecord(MedicalRecordRequestDto medicalRecordRequestDto,Long id);
    public void deleteMedicalRecord(Long id);

}
