package com.sci.da.front.Msg.dto;

import com.sci.da.front.User.entity.UserInfo;

import java.util.Date;
import java.util.List;

public class PersonalManuscriptDTO {

    private String id;

    private String contributors;

    private String manuscriptName;

    private String identifyingName;

    private String manuscriptKind;

    private String manuscriptDes;

    private String manuscriptTitle;

    private Integer auditStatus;

    private Date createTime;

    private Integer limit;

    private Integer page;

    private List<UserInfo> userInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getManuscriptName() {
        return manuscriptName;
    }

    public void setManuscriptName(String manuscriptName) {
        this.manuscriptName = manuscriptName;
    }

    public String getManuscriptKind() {
        return manuscriptKind;
    }

    public void setManuscriptKind(String manuscriptKind) {
        this.manuscriptKind = manuscriptKind;
    }

    public String getManuscriptDes() {
        return manuscriptDes;
    }

    public void setManuscriptDes(String manuscriptDes) {
        this.manuscriptDes = manuscriptDes;
    }

    public String getManuscriptTitle() {
        return manuscriptTitle;
    }

    public void setManuscriptTitle(String manuscriptTitle) {
        this.manuscriptTitle = manuscriptTitle;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
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

    public String getIdentifyingName() {
        return identifyingName;
    }

    public void setIdentifyingName(String identifyingName) {
        this.identifyingName = identifyingName;
    }

    public PersonalManuscriptDTO() {
        super();
    }

    public PersonalManuscriptDTO(String id, String contributors, String manuscriptName, String identifyingName, String manuscriptKind, String manuscriptDes, String manuscriptTitle, Integer auditStatus, Date createTime, Integer limit, Integer page, List<UserInfo> userInfoList) {
        this.id = id;
        this.contributors = contributors;
        this.manuscriptName = manuscriptName;
        this.identifyingName = identifyingName;
        this.manuscriptKind = manuscriptKind;
        this.manuscriptDes = manuscriptDes;
        this.manuscriptTitle = manuscriptTitle;
        this.auditStatus = auditStatus;
        this.createTime = createTime;
        this.limit = limit;
        this.page = page;
        this.userInfoList = userInfoList;
    }
}
