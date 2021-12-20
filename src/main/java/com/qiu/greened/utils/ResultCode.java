package com.qiu.greened.utils;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),

    FAILED(400, "请求失败"),

    ERROR(500, "接口异常"),

    UNAUTHORIZED(401, "未登录"),

    FORBIDDEN(403, "没有相关权限"),

    VALIDATE_FAILED(406, "参数校验失败");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}