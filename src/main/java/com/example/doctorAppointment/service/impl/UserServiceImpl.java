package com.example.doctorAppointment.service.impl;

import com.example.doctorAppointment.dto.request.UserRequestDto;
import com.example.doctorAppointment.dto.response.UserResponseDto;
import com.example.doctorAppointment.model.user.CoreUser;
import com.example.doctorAppointment.repository.userRepo.UserRepo;
import com.example.doctorAppointment.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public CoreUser convertToEntity(UserRequestDto userRequestDto, CoreUser coreUser) {

        coreUser.setUserName(userRequestDto.userName());
        coreUser.setPassword(userRequestDto.password());
        coreUser.setEmail(userRequestDto.email());
        coreUser.setPhone(userRequestDto.phone());
        coreUser.setRole(userRequestDto.role());
        coreUser.setAddress(userRequestDto.address());

        return coreUser;
    }


    @Override
    public void createUser(UserRequestDto userRequestDto) {
        CoreUser coreUser = convertToEntity(userRequestDto,new CoreUser());
        userRepo.save(coreUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        return userRepo.getUserById(id);
    }

    @Override
    public void updateUser(UserRequestDto userRequestDto,Long id) {
        CoreUser coreUser =userRepo.findById(id).get();
        CoreUser coreUser1 = convertToEntity(userRequestDto, coreUser);
        userRepo.save(coreUser1);
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
