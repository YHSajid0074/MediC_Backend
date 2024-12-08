//package com.example.doctorAppointment.config;
//
//import com.example.doctorAppointment.model.coreUser.CoreUser;
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
//       CoreUser coreUser=userRepo.findUserByName(username);
//       if(coreUser==null){
//           throw new UsernameNotFoundException(username);
//       }
//       return new UserPrinciple(coreUser);
//
//    }
//}
