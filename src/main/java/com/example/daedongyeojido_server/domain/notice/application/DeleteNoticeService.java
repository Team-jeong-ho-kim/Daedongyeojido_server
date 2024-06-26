package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.dao.FieldRepository;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.dao.StartEndEndTimeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteNoticeService {

    private final NoticeFacade noticeFacade;

    private final NoticeRepository noticeRepository;

    private final FieldRepository fieldRepository;

    private final StartEndEndTimeRepository startEndEndTimeRepository;

    private final UserFacade userFacade;

    @Transactional
    public void deleteNotice(Long noticeId) {
        Notice notice = noticeFacade.noticeFacade(noticeId);

        if(!userFacade.currentUser().getMyClub().equals(notice.getClubName())) throw ClubMisMatchException.EXCEPTION;

        fieldRepository.deleteAllByNotice(notice);
        startEndEndTimeRepository.deleteAllByNotice(notice);
        notice.getClubName().addNotice(null);
        noticeRepository.deleteById(noticeId);
    }
}