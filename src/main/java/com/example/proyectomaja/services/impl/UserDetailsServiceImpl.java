package com.example.proyectomaja.services.impl;


import com.example.proyectomaja.domain.User;

import com.example.proyectomaja.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Autentica un usuario de la base de datos
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private UserRepository userRepository;

 

    @Autowired
    PasswordEncoder passwordEncoder;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {



        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(),new ArrayList<>());

    }


//    @Override
//    public Boolean findByEmailAndPassword(String email, String password) {
//        if(userRepository.existsByEmail(email)) {
//            User user = userRepository.findUserByEmail(email);
//            return passwordEncoder.matches(password, user.getPassword());
//        }
//        return false;
//    }

}
