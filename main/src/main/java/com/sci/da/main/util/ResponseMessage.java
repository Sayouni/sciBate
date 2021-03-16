package com.sci.da.main.util;

public class ResponseMessage <T>{

    private String status;
    private String msg;
    private T data;

    private ResponseMessage(String status) {
        this.status = status;
    }

    private ResponseMessage(String status, T data) {
        this.status = status;
        this.data = data;
    }

    private ResponseMessage(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseMessage(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public String getStatus() {
        return status;
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
