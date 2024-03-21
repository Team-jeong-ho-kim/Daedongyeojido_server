package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.notice.dao.FieldRepository;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.dao.StartEndEndTimeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Field;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.StartAndEndTime;
import com.example.daedongyeojido_server.domain.notice.dto.request.CreateNoticeRequest;
import com.example.daedongyeojido_server.domain.notice.dto.request.FieldRequest;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateNoticeService {

    private final UserFacade userFacade;

    private final NoticeRepository noticeRepository;

    private final FieldRepository fieldRepository;

    private final StartEndEndTimeRepository startEndEndTimeRepository;

    private final ClubRepository clubRepository;

    @Transactional
    public void createNotice(CreateNoticeRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

        if(!userFacade.currentUser().getMyClub().equals(club)) throw ClubMisMatchException.EXCEPTION;

        Notice notice = noticeRepository.save(
                Notice.builder()
                        .clubName(club)
                        .noticeTitle(request.getNoticeTitle())
                        .noticeExplain(request.getNoticeExplain())
                        .fields(request.getFields().stream().map(Field::new).toList())
                        .applyMethod(request.getApplyMethod())
                        .inquiry(request.getInquiry())
                        .weWant(request.getWeWant())
                        .assignment(request.getAssignment())
                        .build());

        for(int i = 0;i<request.getFields().size(); i++) {
            FieldRequest fieldRequest = request.getFields().get(i);

            fieldRepository.save(
                    Field.builder()
                            .major(fieldRequest.getMajor())
                            .toDo(fieldRequest.getToDo())
                            .notice(notice)
                            .build());
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

        club.addNotice(notice); // 이렇게 하지 말고 동아리 이름으로 조회 ㄱㄱ
    }
}