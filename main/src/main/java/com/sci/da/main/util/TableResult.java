package com.sci.da.main.util;

public class TableResult{

    public static <T> ResponseTable<T> success(String code, String message,int count, T t) {
        return new ResponseTable<T>(code,message,count,t);
    }
    public static <T> ResponseTable<T> error(String code, String message) {
        return new ResponseTable<T>(code,message);
    }
}