package com.example.doctorAppointment.repository.hospitalRepo;

import com.example.doctorAppointment.dto.response.HospitalResponseDto;
import com.example.doctorAppointment.model.hospital.Hospital;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Long> {

    @EntityGraph( attributePaths = { "doctors" } )
    @Query(
            """
              SELECT h
            FROM Hospital h
           WHERE h.id=:id
          """
         )
    public HospitalResponseDto findHospitalById(Long id);

    @EntityGraph( attributePaths = { "doctors" } )
    @Query(
            """
          SELECT h
          From Hospital h
          """
    )
    public List<HospitalResponseDto> findAllHospitals();


    @Query(
            """
            SELECT h
            FROM Hospital h
            WHERE h.hospitalName LIKE %:name%
            """
    )
    public HospitalResponseDto findHospitalByHospitalName(String name);
}
