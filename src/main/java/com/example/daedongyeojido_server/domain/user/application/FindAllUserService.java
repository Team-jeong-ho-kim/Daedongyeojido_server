package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.dto.request.PickSecretRequest;
import com.example.daedongyeojido_server.domain.user.dto.response.AllUserResponse;
import com.example.daedongyeojido_server.domain.user.exception.InvalidKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllUserService {

    private final UserRepository userRepository;

    @Value("${key.pick-secret-key}")
    private String secretKey;

    @Transactional
    public List<AllUserResponse> findAllUser(PickSecretRequest request) {

        if (!secretKey.equals(request.getPickSecretKey())) throw InvalidKeyException.EXCEPTION;

        return userRepository.findAll()
                .stream()
                .map(AllUserResponse::new)
                .collect(Collectors.toList());
    }
}