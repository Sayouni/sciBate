package com.sci.da.main.util;

public enum ResponseCode {
    SUCCESS("200", "true"),
    ERROR("500", "error");

    private final String code;
    private final String desc;

    ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}