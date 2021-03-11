package com.sci.da.front.Notice.dto;

import java.util.Date;

public class NoticeCenterDTO {

    private String id;

    private String noticeTitle;

    private String noticeDetail;

    private Integer readStatus;

    private String publishManager;

    private String delFlag;

    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeDetail() {
        return noticeDetail;
    }

    public void setNoticeDetail(String noticeDetail) {
        this.noticeDetail = noticeDetail;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getPublishManager() {
        return publishManager;
    }

    public void setPublishManager(String publishManager) {
        this.publishManager = publishManager;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public NoticeCenterDTO() {
        super();
    }

    public NoticeCenterDTO(String id, String noticeTitle, String noticeDetail, Integer readStatus, String publishManager, String delFlag, Date createTime) {
        this.id = id;
        this.noticeTitle = noticeTitle;
        this.noticeDetail = noticeDetail;
        this.readStatus = readStatus;
        this.publishManager = publishManager;
        this.delFlag = delFlag;
        this.createTime = createTime;
    }
}
