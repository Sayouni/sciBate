package com.sci.da.background.Manager.dto;

import java.util.Date;

public class AppealInfoDTO {

    private String id;

    private String appealId;

    private String handleStatus;

    private String appealKind;

    private String detail;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppealId() {
        return appealId;
    }

    public void setAppealId(String appealId) {
        this.appealId = appealId;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
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

    public AppealInfoDTO() {
        super();
    }

    public AppealInfoDTO(String id, String appealId, String handleStatus, String appealKind, String detail, Date createTime) {
        this.id = id;
        this.appealId = appealId;
        this.handleStatus = handleStatus;
        this.appealKind = appealKind;
        this.detail = detail;
        this.createTime = createTime;
    }
}
