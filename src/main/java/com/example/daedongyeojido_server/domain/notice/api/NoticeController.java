package com.example.daedongyeojido_server.domain.notice.api;

import com.example.daedongyeojido_server.domain.notice.application.AddNoticeQuestService;
import com.example.daedongyeojido_server.domain.notice.application.CreateNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.DeleteNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryAllNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryApplyPageService;
import com.example.daedongyeojido_server.domain.notice.application.QueryNoticeInfoService;
import com.example.daedongyeojido_server.domain.notice.application.SelectMajorService;
import com.example.daedongyeojido_server.domain.notice.dto.request.CreateNoticeRequest;
import com.example.daedongyeojido_server.domain.notice.dto.request.MajorRequest;
import com.example.daedongyeojido_server.domain.notice.dto.request.NoticeQuestRequest;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeInfoResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.ApplyPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final CreateNoticeService createNoticeService;

    private final SelectMajorService selectMajorService;

    private final AddNoticeQuestService addNoticeQuestService;

    private final QueryApplyPageService queryApplyPageService;

    private final QueryAllNoticeService queryAllNoticeService;

    private final QueryNoticeInfoService queryNoticeInfoService;

    private final DeleteNoticeService deleteNoticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createNotice(@RequestBody @Valid CreateNoticeRequest request) {
        createNoticeService.createNotice(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/select")
    public void selectMajor(@RequestBody @Valid MajorRequest request) {
        selectMajorService.selectMajor(request);
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
    public List<NoticeResponse> queryAllNotice() {
        return queryAllNoticeService.queryAllNotice();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info/{noticeId}")
    public NoticeInfoResponse queryNoticeInfo(@PathVariable Long noticeId) {
        return queryNoticeInfoService.queryNoticeInfo(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{noticeId}")
    public void deleteNotice(@PathVariable Long noticeId) {
        deleteNoticeService.deleteNotice(noticeId);
    }
}