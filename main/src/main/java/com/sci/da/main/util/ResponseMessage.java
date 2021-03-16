package com.sci.da.main.util;

public class ResponseMessage <T>{

    private String code;
    private String msg;
    private T data;

    private ResponseMessage(String code) {
        this.code = code;
    }

    private ResponseMessage(String code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResponseMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResponseMessage(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public String getcode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> ResponseMessage<T> createBySuccess() {
        return new
                ResponseMessage<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseMessage<T> createBySuccess(T data) {
        return new
                ResponseMessage<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseMessage<T>
    createBySuccessMessage(String msg) {
        return new
                ResponseMessage<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ResponseMessage<T>
    createBySuccessCodeMessage(String msg, T data) {
        return new ResponseMessage<T>
                (ResponseCode.SUCCESS.getCode(), msg, data)
                ;
    }

    public static <T> ResponseMessage<T>
    successReq(String msg, T data) {
        return new ResponseMessage<T>
                (ResponseCode.SUCCESS.getCode(), msg, data)
                ;
    }

    public static <T> ResponseMessage<T> createByError() {
        return new ResponseMessage<T>
                (ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc())
                ;
    }

    public static <T> ResponseMessage<T> createByErrorMessage
            (String errorMessage) {
        return new
                ResponseMessage<T>
                (ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ResponseMessage<T> createByErrorCodeMessage
            (String erroCode, String errorMessage) {
        return new ResponseMessage<T>(erroCode, errorMessage);
    }
}
