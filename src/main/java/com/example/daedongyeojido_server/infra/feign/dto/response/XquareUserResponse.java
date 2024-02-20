package com.example.daedongyeojido_server.infra.feign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class XquareUserResponse {
    private String account_id;

    private String name;

    private Integer grade;

    private Integer class_num;

    private Integer num;

    private String user_role;
}