package com.example.doctorAppointment.repository.ambulanceRepo;

import com.example.doctorAppointment.dto.response.AmbulanceResponseDto;
import com.example.doctorAppointment.model.ambulance.Ambulance;
import com.example.doctorAppointment.model.ambulance.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceRepo extends JpaRepository<Ambulance, Long> {

    @Query(
            """
                    select a
                    from Ambulance a
                    """
    )
    public List<AmbulanceResponseDto> findAllAmbulance();


    @Query(
            """
                        select A
                        from Ambulance A
                        where A.id=:id
                    """
    )
    public AmbulanceResponseDto findAmbulanceById(Long id);

    @Query(
            """
              select A 
              from Ambulance A 
              where A.availabilityStatus=:status
                    """
    )
    public List<AmbulanceResponseDto> findAvailableAmbulance(String status);


    @Query("""
            Select A 
            From Ambulance A 
            where A.hospital=:hospitalId
            """)
    public List<AmbulanceResponseDto> findAmbulanceByHosptial(Long hospitalId);

    @Query("""
            Select A
            From Ambulance A 
            where A.currentLocation=:location
            """)
    public List<AmbulanceResponseDto> findAmbulanceByLocation(String location);

}
