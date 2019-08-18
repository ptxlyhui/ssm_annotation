package com.lyhui.dto;

import lombok.Data;

/*
* 消息返回状态码
* */
@Data
public class ResponseCode {

    public static final int SUCCESS = 2000;

    public static final int FAIL = 4000;

    private Integer code;

    private String msg;

    private String detail;
}
