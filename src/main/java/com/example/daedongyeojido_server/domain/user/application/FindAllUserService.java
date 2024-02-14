package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.dto.response.AllUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllUserService {

    private final UserRepository userRepository;

    @Transactional
    public List<AllUserResponse> findAllUser() {

        return userRepository.findAll()
                .stream()
                .map(AllUserResponse::new)
                .collect(Collectors.toList());
    }
}
