package com.example.daedongyeojido_server.global.security.auth;

import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String classNumber) {
        User user = userRepository.findByClassNumber(classNumber)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new CustomUserDetails(user);
    }

}
