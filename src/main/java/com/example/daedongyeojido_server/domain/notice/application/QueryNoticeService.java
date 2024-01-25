package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryNoticeService {

    private final NoticeRepository noticeRepository;

    private final ClubRepository clubRepository;

    public List<NoticeResponse> queryNotice(String clubName) {
        Club club = clubRepository.findByClubName(clubName);

        return noticeRepository.findAllByClubName(club)
                .stream()
                .map(NoticeResponse::new)
                .collect(Collectors.toList());
    }
}
