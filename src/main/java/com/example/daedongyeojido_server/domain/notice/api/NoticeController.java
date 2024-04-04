package com.example.daedongyeojido_server.domain.notice.api;

import com.example.daedongyeojido_server.domain.notice.application.AddNoticeQuestService;
import com.example.daedongyeojido_server.domain.notice.application.CreateNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.DeleteNoticeQuestService;
import com.example.daedongyeojido_server.domain.notice.application.DeleteNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryAllNoticeQuestService;
import com.example.daedongyeojido_server.domain.notice.application.QueryAllNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryApplyPageService;
import com.example.daedongyeojido_server.domain.notice.application.QueryNoticeInfoService;
import com.example.daedongyeojido_server.domain.notice.application.UpdateNoticeService;
import com.example.daedongyeojido_server.domain.notice.dto.request.CreateNoticeRequest;
import com.example.daedongyeojido_server.domain.notice.dto.request.NoticeQuestRequest;
import com.example.daedongyeojido_server.domain.notice.dto.request.UpdateNoticeRequest;
import com.example.daedongyeojido_server.domain.notice.dto.response.AllNoticeResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.ApplyPageResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeInfoResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeQuestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final CreateNoticeService createNoticeService;

    private final AddNoticeQuestService addNoticeQuestService;

    private final QueryApplyPageService queryApplyPageService;

    private final QueryAllNoticeService queryAllNoticeService;

    private final QueryNoticeInfoService queryNoticeInfoService;

    private final QueryAllNoticeQuestService queryAllNoticeQuestService;

    private final UpdateNoticeService updateNoticeService;

    private final DeleteNoticeService deleteNoticeService;

    private final DeleteNoticeQuestService deleteNoticeQuestService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createNotice(@RequestBody @Valid CreateNoticeRequest request) {
        createNoticeService.createNotice(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-quest")
    public void addNoticeQuest(@RequestBody @Valid NoticeQuestRequest request) {
        addNoticeQuestService.addNoticeQuest(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/apply/{noticeId}")
    public ApplyPageResponse queryApplyPage(@PathVariable Long noticeId) {
        return queryApplyPageService.queryApplyPage(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public AllNoticeResponse queryAllNotice() {
        return queryAllNoticeService.queryAllNotice();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info/{noticeId}")
    public NoticeInfoResponse queryNoticeInfo(@PathVariable Long noticeId) {
        return queryNoticeInfoService.queryNoticeInfo(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all-quest/{noticeId}")
    public List<NoticeQuestResponse> queryAllNoticeQuest(@PathVariable Long noticeId) {
        return queryAllNoticeQuestService.queryAllNoticeQuest(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    public void updateNotice(@RequestBody @Valid UpdateNoticeRequest request) {
        updateNoticeService.updateNotice(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{noticeId}")
    public void deleteNotice(@PathVariable Long noticeId) {
        deleteNoticeService.deleteNotice(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete-noticeQuest/{noticeQuestId}")
    public void noticeQuestDelete(@PathVariable Long noticeQuestId) {
        deleteNoticeQuestService.deleteNoticeQuest(noticeQuestId);
    }
}