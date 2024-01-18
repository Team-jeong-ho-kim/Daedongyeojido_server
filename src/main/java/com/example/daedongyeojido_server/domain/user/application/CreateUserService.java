package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.exception.ClubNotFoundException;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;

    private final ClubRepository clubRepository;

    public void createUser(CreateUserRequest request) {
        Club myclub = clubRepository.findById(request.getClubName())
                        .orElseThrow(()-> ClubNotFoundException.EXCEPTION);

        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .classNumber(request.getClassNumber())
                        .part(request.getPart())
                        .myClub(myclub)
                        .build());
    }
}
