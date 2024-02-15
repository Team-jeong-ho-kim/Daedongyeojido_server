package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeResponse;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.user.application.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryNoticeService {

    private final UserFacade userFacade;

    private final NoticeRepository noticeRepository;

    private final ClubRepository clubRepository;

    private final ReportRepository reportRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponse> queryNotice(String clubName) {
        User user = userFacade.currentUser();

        Club club = clubRepository.findByClubName(clubName);

        List<Notice> notices = noticeRepository.findAllByClubName(club);

        List<NoticeResponse> noticeResponses = noticeRepository.findAllByClubName(club)
                .stream()
                .map(NoticeResponse::new)
                .collect(Collectors.toList());

        for(int i=0; i<noticeResponses.size(); i++) {
            if(!(reportRepository.findAllByClassNumberAndNotice(user.getClassNumber(), notices.get(i)).isEmpty())) {
                noticeResponses.get(i).apply();
            }
        }

        return noticeResponses;
    }
}
