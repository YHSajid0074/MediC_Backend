//package com.example.doctorAppointment.config;
//
//import com.example.doctorAppointment.model.user.User;
//import com.example.doctorAppointment.repository.userRepo.UserRepo;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    public UserRepo userRepo;
//    public CustomUserDetailsService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user=userRepo.findUserByName(username);
//       if(user==null){
//           throw new UsernameNotFoundException(username);
//       }
//       return new UserPrinciple(user);
//
//    }
//}
