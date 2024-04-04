package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.response.AllNoticeResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeResponse;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllNoticeService {

    private final NoticeRepository noticeRepository;

    private final UserFacade userFacade;

    private final ReportRepository reportRepository;

    @Transactional(readOnly = true)
    public AllNoticeResponse queryAllNotice() {
        List<Notice> allNotice = noticeRepository.findAll();

        User user;

        List<NoticeResponse> noticeResponses = allNotice
                .stream()
                .map(NoticeResponse::new)
                .collect(Collectors.toList());

        if(userFacade.currentNullUser()==null) {
            user = null;
        }
        else {
            user = userFacade.currentUser();

            for (int i = 0; i < noticeResponses.size(); i++) {
                if (!(reportRepository.findAllByClassNumberAndNotice(user.getClassNumber(), allNotice.get(i)).isEmpty())) {
                    noticeResponses.get(i).apply();
                }
            }
        }

        return new AllNoticeResponse(noticeRepository.existsByClubName((user == null) ? null : user.getMyClub()), noticeResponses);
    }
}
