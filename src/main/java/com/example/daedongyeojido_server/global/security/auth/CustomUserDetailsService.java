package com.example.daedongyeojido_server.global.security.auth;

import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final CustomUserRepository customUserRepository;

    @Override
    public UserDetails loadUserByUsername(String classNumber) {
        if(userRepository.findByClassNumber(classNumber).isPresent()) {
            User user = userRepository.findByClassNumber(classNumber)
                    .orElseThrow(()->UserNotFoundException.EXCEPTION);
            return new CustomUserDetails(user);
        }

        else {
            User user = customUserRepository.findTeacherByName(classNumber)
                    .orElseThrow(()->UserNotFoundException.EXCEPTION);
            return new CustomUserDetails(user);
        }
    }
}
