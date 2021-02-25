package com.sci.da.main.util;

public class ResponseTable<T> {
    private String code;
    private String msg;
    private T data;
    private int count;

    public ResponseTable() {
    }


    public ResponseTable(String code, String msg, int count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    public ResponseTable(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
