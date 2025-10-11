package com.github.nikhilsutarIN.todoapp.config;

import com.github.nikhilsutarIN.todoapp.entity.User;
import com.github.nikhilsutarIN.todoapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);

        if(ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
