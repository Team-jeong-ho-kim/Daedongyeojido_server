package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.dao.FieldRepository;
import com.example.daedongyeojido_server.domain.notice.dao.StartEndEndTimeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Field;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.StartAndEndTime;
import com.example.daedongyeojido_server.domain.notice.dto.request.FieldRequest;
import com.example.daedongyeojido_server.domain.notice.dto.request.UpdateNoticeRequest;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateNoticeService {

    private final NoticeFacade noticeFacade;

    private final UserFacade userFacade;

    private final FieldRepository fieldRepository;

    private final StartEndEndTimeRepository startEndEndTimeRepository;

    @Transactional
    public void updateNotice(UpdateNoticeRequest request) {
        Notice notice = noticeFacade.noticeFacade(request.getNoticeId());

        if(!userFacade.currentUser().getMyClub().equals(notice.getClubName())) throw ClubMisMatchException.EXCEPTION;

        startEndEndTimeRepository.deleteAllByNotice(notice);
        fieldRepository.deleteAllByNotice(notice);

        notice.updateNotice(request.getNoticeTitle(), request.getNoticeExplain(), request.getClubExplain(),
                request.getApplyMethod(), request.getInquiry(), request.getWeWant(), request.getAssignment());

        for(int i = 0; i<request.getFields().size(); i++) {
            FieldRequest fieldRequest = request.getFields().get(i);

            Field field = fieldRepository.save(
                    Field.builder()
                            .major(fieldRequest.getMajor())
                            .toDo(fieldRequest.getToDo())
                            .notice(notice)
                            .build());

            notice.addField(field);
        }

        StartAndEndTime recruitDay = startEndEndTimeRepository.save(
                StartAndEndTime.builder()
                        .startDay(request.getRecruitDay().getStartDay())
                        .endDay(request.getRecruitDay().getEndDay())
                        .notice(notice)
                        .build());

        StartAndEndTime interviewDay = startEndEndTimeRepository.save(
                StartAndEndTime.builder()
                        .startDay(request.getInterviewDay().getStartDay())
                        .endDay(request.getInterviewDay().getEndDay())
                        .notice(notice)
                        .build());

        notice.setRecruitDay(recruitDay);
        notice.setInterviewDay(interviewDay);
    }
}
