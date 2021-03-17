package com.sci.da.main.util;

public enum ResponseCode {
    SUCCESS("200"),
    ERROR("500");

    private final String code;

    ResponseCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

}