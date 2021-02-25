package com.sci.da.front.Notice.Dto;

import java.util.Date;

public class NoticeDTO {

    private String id;

    private String account;

    private String noticeId;

    private String noticeTitle;

    private String noticeDetail;

    private Integer readStatus;

    private String publishManager;

    private Date createTime;

    private Integer limit;

    private Integer page;

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

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public NoticeDTO() {
        super();
    }

    public NoticeDTO(String id, String account, String noticeId, String noticeTitle, String noticeDetail, Integer readStatus, String publishManager, Date createTime, Integer limit, Integer page) {
        this.id = id;
        this.account = account;
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeDetail = noticeDetail;
        this.readStatus = readStatus;
        this.publishManager = publishManager;
        this.createTime = createTime;
        this.limit = limit;
        this.page = page;
    }
}
