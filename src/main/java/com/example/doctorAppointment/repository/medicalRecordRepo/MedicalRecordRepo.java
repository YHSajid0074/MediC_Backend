package com.example.doctorAppointment.repository.medicalRecordRepo;

import com.example.doctorAppointment.model.medicalRecord.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepo extends JpaRepository<MedicalRecord,Long> {
}
