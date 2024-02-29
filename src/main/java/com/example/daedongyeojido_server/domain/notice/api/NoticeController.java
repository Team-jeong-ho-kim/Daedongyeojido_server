package com.example.daedongyeojido_server.domain.notice.api;

import com.example.daedongyeojido_server.domain.notice.application.CreateNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.DeleteNoticeService;
import com.example.daedongyeojido_server.domain.notice.application.QueryNoticeService;
import com.example.daedongyeojido_server.domain.notice.dto.request.CreateNoticeRequest;
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

    private final QueryNoticeService queryNoticeService;

    private final DeleteNoticeService deleteNoticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createNotice(@RequestBody @Valid CreateNoticeRequest request) {
        createNoticeService.createNotice(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{clubName}")
    public List<NoticeResponse> queryNotice(@PathVariable String clubName) {
        return queryNoticeService.queryNotice(clubName);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{noticeId}")
    public void deleteNotice(@PathVariable Long noticeId) {
        deleteNoticeService.deleteNotice(noticeId);
    }
}