package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.request.ProfileImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateProfileImageService {

    private final UserFacade userFacade;

    @Transactional
    public void updateProfileImage(ProfileImageRequest request) {
        User user = userFacade.currentUser();

        user.updateProfile(request.getProfileImageUrl());
    }
}
