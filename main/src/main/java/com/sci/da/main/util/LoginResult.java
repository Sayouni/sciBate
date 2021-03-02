package com.sci.da.main.util;

public class LoginResult {

    private String account;

    private String status;

    private Integer authority;

    public LoginResult() {
    }

    public LoginResult(String account, String status) {
        this.account = account;
        this.status = status;
    }

    public LoginResult(String account, String status, Integer authority) {
        this.account = account;
        this.status = status;
        this.authority = authority;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}
