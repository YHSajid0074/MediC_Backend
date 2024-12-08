package com.example.doctorAppointment.service;

import com.example.doctorAppointment.dto.request.UserRequestDto;
import com.example.doctorAppointment.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;

public interface UserService {

   public void createUser(UserRequestDto user);

   public UserResponseDto getUserById(Long id);

   public void updateUser(UserRequestDto user,Long id);

   public void deleteUser(Long id);

   public Page<UserResponseDto> getAllUsers(int page, int size, String sortBy, String sortOrder);

}
