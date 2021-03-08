package com.sci.da.front.User.dto;

import java.util.Date;

public class AccountAppealDTO {

    private String id;

    private String account;

    private String appealKind;

    private String detail;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAppealKind() {
        return appealKind;
    }

    public void setAppealKind(String appealKind) {
        this.appealKind = appealKind;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public AccountAppealDTO() {
        super();
    }

    public AccountAppealDTO(String id, String account, String appealKind, String detail, Date createTime) {
        this.id = id;
        this.account = account;
        this.appealKind = appealKind;
        this.detail = detail;
        this.createTime = createTime;
    }
}
