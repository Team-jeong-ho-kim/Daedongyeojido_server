package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.request.CreateNoticeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNoticeService {

    private final NoticeRepository noticeRepository;

    private final ClubRepository clubRepository;

    public void createNotice(CreateNoticeRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

        noticeRepository.save(
                Notice.builder()
                        .major(request.getMajor())
                        .deadline(request.getDeadline())
                        .clubName(club)
                        .build());
    }
}
