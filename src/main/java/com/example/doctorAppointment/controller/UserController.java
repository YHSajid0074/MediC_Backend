package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.UserRequestDto;
import com.example.doctorAppointment.dto.response.UserResponseDto;
import com.example.doctorAppointment.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String>createUser(@RequestBody UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);
        return ResponseEntity.ok("User Created");
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
      UserResponseDto userResponseDto=  userService.getUserById(userId);
      return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String>deleteUserById(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User Deleted");
    }

    @GetMapping("All")
    public ResponseEntity<Page<UserResponseDto>>getAllUsers(int page, int size, String sortBy, String sortOrder) {
      return ResponseEntity.ok(userService.getAllUsers(page,size,sortBy,sortOrder));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String>updateUser(@RequestBody UserRequestDto userRequestDto,@PathVariable Long id) {
        userService.updateUser(userRequestDto,id);
        return ResponseEntity.ok("User Updated");
    }

}
