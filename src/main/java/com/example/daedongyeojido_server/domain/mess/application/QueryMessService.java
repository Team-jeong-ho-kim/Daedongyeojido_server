package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.dto.response.QueryMessResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMessService {

    private final UserFacade userFacade;

    private final MessRepository messRepository;

    @Transactional(readOnly = true)
    public List<QueryMessResponse> queryMess() {

        User teacher = userFacade.currentUser();

        List<Mess> messes = messRepository.findAll();

        List<QueryMessResponse> queryMessResponses = messRepository.findAll()
                .stream()
                .map(QueryMessResponse::new)
                .collect(Collectors.toList());

        for(int i=0; i<queryMessResponses.size(); i++) {
            if(messes.get(i).getAcceptTeachers().contains(teacher.getName())) {
                queryMessResponses.get(i).accept();
            }
        }

        return queryMessResponses;
    }
}