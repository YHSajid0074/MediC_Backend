package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.MedicalRecordRequestDto;
import com.example.doctorAppointment.dto.response.MedicalRecordResponseDto;
import com.example.doctorAppointment.model.medicalRecord.MedicalRecord;
import com.example.doctorAppointment.repository.doctorRepo.DoctorRepo;
import com.example.doctorAppointment.repository.medicalRecordRepo.MedicalRecordRepo;
import com.example.doctorAppointment.repository.userRepo.UserRepo;
import com.example.doctorAppointment.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    MedicalRecordRepo medicalRecordRepo;
    DoctorRepo doctorRepo;
    UserRepo userRepo;

    public MedicalRecordServiceImpl(MedicalRecordRepo medicalRecordRepo, DoctorRepo doctorRepo, UserRepo userRepo) {
        this.medicalRecordRepo = medicalRecordRepo;
        this.doctorRepo = doctorRepo;
        this.userRepo = userRepo;
    }

    public MedicalRecord ConvertToEntity(MedicalRecordRequestDto medicalRecordRequestDto,MedicalRecord medicalRecord) {

        medicalRecord.setMedications(medicalRecordRequestDto.medications());
        medicalRecord.setDiagnosis(medicalRecordRequestDto.diagnosis());
        medicalRecord.setTreatmentPlan(medicalRecordRequestDto.treatmentPlan());
        medicalRecord.setDoctor(doctorRepo.findById(medicalRecordRequestDto.doctorId()).get());
        medicalRecord.setCoreUser(userRepo.findById(medicalRecordRequestDto.userId()).get());

        return medicalRecord;
    }


    @Override
    public void createMedicalRecord(MedicalRecordRequestDto medicalRecordRequestDto) {

       MedicalRecord medicalRecord1=ConvertToEntity(medicalRecordRequestDto,new MedicalRecord());

       medicalRecordRepo.save(medicalRecord1);

    }


    @Override
    public Set<MedicalRecordResponseDto> getAllMedicalRecord() {
        return medicalRecordRepo.findAllMedicalRecord();
    }

    @Override
    public MedicalRecordResponseDto getMedicalRecordById(Long id) {
        return medicalRecordRepo.findMedicalRecordById(id);
    }

    @Override
    public void updateMedicalRecord(MedicalRecordRequestDto medicalRecordRequestDto,Long id) {

     MedicalRecord medicalRecord=medicalRecordRepo.findById(id).get();
     MedicalRecord updatedMedicalRecord=ConvertToEntity(medicalRecordRequestDto,medicalRecord);

     medicalRecordRepo.save(updatedMedicalRecord);

    }

    @Override
    public void deleteMedicalRecord(Long id) {
        medicalRecordRepo.deleteById(id);
    }
}
