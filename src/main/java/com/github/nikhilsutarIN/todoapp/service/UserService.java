package com.github.nikhilsutarIN.todoapp.service;

import com.github.nikhilsutarIN.todoapp.entity.User;
import com.github.nikhilsutarIN.todoapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User addUser(User u) {
        User existingUser = userRepository.findByEmail(u.getEmail()).orElse(null);

        if (existingUser != null) {
            return null;
        }

        User user = new User();
        user.setFirstname(u.getFirstname());
        user.setLastname(u.getLastname());
        user.setEmail(u.getEmail());
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.setRole("ROLE_USER");
        user.setTodos(new ArrayList<>());

        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}
