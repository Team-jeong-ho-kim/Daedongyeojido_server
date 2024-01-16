package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;

    public void createUser(CreateUserRequest request) {
        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .classNumber(request.getClassNumber())
                        .part(request.getPart())
                        .myClub(request.getClubName())
                        .build());
    }
}
