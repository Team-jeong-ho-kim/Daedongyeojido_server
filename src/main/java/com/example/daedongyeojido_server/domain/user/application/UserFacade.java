package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.NotAuthenticatedException;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    private final CustomUserRepository customUserRepository;

    public User currentStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증되지 않는 학생입니다.");
        }

        String classNumber = authentication.getName();

        return userRepository.findByClassNumber(classNumber)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User currentTeacher() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증되지 않는 선생님입니다.");
        }

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            throw new NotAuthenticatedException("인증되지 않는 선생님입니다.");
        }

        UserDetails userDetails = (UserDetails) principal;
        String name = userDetails.getPassword();

        return customUserRepository.findTeacherByName(name)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
