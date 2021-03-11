package com.sci.da.background.ManagerNotice.dto;

import java.util.Date;
import java.util.List;

public class NoticePublishDTO {

    /** 分组idList **/
    public List<String> userList;

    /** 分组id **/
    private String id;

    /** 通知id **/
    private String noticeId;

    /** 通知标题 **/
    private String noticeTitle;

    /** 通知详情 **/
    private String noticeDetail;

    /** 阅读状态 **/
    private Integer readStatus;

    /** 发布通知的管理员account **/
    private String publishManager;

    /** 创建时间 **/
    private Date createTime;

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public NoticePublishDTO() {
        super();
    }

    public NoticePublishDTO(List<String> userList, String id, String noticeId, String noticeTitle, String noticeDetail, Integer readStatus, String publishManager, Date createTime) {
        this.userList = userList;
        this.id = id;
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeDetail = noticeDetail;
        this.readStatus = readStatus;
        this.publishManager = publishManager;
        this.createTime = createTime;
    }
}
