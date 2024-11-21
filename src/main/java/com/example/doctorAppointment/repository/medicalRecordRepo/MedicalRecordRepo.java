package com.example.doctorAppointment.repository.medicalRecordRepo;

import com.example.doctorAppointment.dto.response.MedicalRecordResponseDto;
import com.example.doctorAppointment.model.medicalRecord.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MedicalRecordRepo extends JpaRepository<MedicalRecord, Long> {

    @Query("""
            SELECT r
            From MedicalRecord r
            where r.recordId=:id
            """)
    public MedicalRecordResponseDto findMedicalRecordById(Long id);

    @Query("""
            SELECT r
            From MedicalRecord r
            """)
    public Set<MedicalRecordResponseDto> findAllMedicalRecord();
}
