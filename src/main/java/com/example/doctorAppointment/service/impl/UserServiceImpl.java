package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.UserRequestDto;
import com.example.doctorAppointment.dto.response.UserResponseDto;
import com.example.doctorAppointment.model.user.User;
import com.example.doctorAppointment.repository.userRepo.UserRepo;
import com.example.doctorAppointment.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User convertToEntity(UserRequestDto userRequestDto, User user) {

        user.setUserName(userRequestDto.userName());
        user.setPassword(userRequestDto.password());
        user.setEmail(userRequestDto.email());
        user.setPhone(userRequestDto.phone());
        user.setRole(userRequestDto.role());
        user.setAddress(userRequestDto.address());

        return user;
    }


    @Override
    public void createUser(UserRequestDto userRequestDto) {
        User user = convertToEntity(userRequestDto,new User());
        userRepo.save(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        return userRepo.getUserById(id);
    }

    @Override
    public void updateUser(UserRequestDto user) {

    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Page<UserResponseDto> getAllUsers(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

       Page<UserResponseDto> users = userRepo.getAllUsers(pageable);
       return users;
    }
}
