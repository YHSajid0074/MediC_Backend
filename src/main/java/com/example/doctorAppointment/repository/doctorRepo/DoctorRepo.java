package com.example.doctorAppointment.repository.doctorRepo;

import com.example.doctorAppointment.dto.response.DoctorResponseDto;
import com.example.doctorAppointment.model.doctor.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {

    @Query(
            """
       SELECT  d
       from Doctor d
       where d.doctorId=:doctorId
       """
    )
    DoctorResponseDto findDoctorById(Long doctorId);

    @Query(""" 
  SELECT d from Doctor d
          """)
    Page<DoctorResponseDto>findAllDoctor(Pageable pageable);

    @Query(""" 
  SELECT d from Doctor d
  """)
    Set<DoctorResponseDto> findDoctors();
}
