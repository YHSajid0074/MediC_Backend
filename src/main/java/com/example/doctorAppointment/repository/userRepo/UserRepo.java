package com.example.doctorAppointment.repository.userRepo;
import com.example.doctorAppointment.dto.response.UserResponseDto;
import com.example.doctorAppointment.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query( """
                SELECT
                    u.userName as userName,
                    u.email as email,
                    u.role as role,
                    u.phone as phone,
                    u.address as address
                FROM
                   User u
                WHERE
                    u.userId = :id
            """ )
   public UserResponseDto getUserById(@Param( "id" ) Long id);


    @Query("""
                SELECT
                    u.userName as userName,
                    u.email as email,
                    u.role as role,
                    u.phone as phone,
                    u.address as address
                FROM
                   User u
 """)
    public Page<UserResponseDto> getAllUsers(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.userName = :name")
    public User findUserByName(String name);
}
