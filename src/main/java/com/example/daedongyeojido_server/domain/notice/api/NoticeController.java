package com.example.daedongyeojido_server.domain.notice.api;

import com.example.daedongyeojido_server.domain.notice.application.CreateNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.DeleteNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryAllNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryNoticeInfoService;
import com.example.daedongyeojido_server.domain.notice.dto.request.CreateNoticeRequest;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeInfoResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeResponse;
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

    private final QueryAllNoticeService queryAllNoticeService;

    private final QueryNoticeInfoService queryNoticeInfoService;

    private final DeleteNoticeService deleteNoticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createNotice(@RequestBody @Valid CreateNoticeRequest request) {
        createNoticeService.createNotice(request);
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