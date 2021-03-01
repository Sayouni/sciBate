package com.sci.da.front.Msg.Dto;

import java.util.Date;

public class ManuscriptDTO {

    private String id;

    private String contributors;

    private String manuscriptName;

    private String identifyingName;

    private String manuscriptKind;

    private String manuscriptDes;

    private String manuscriptTitle;

    private Integer auditStatus;

    private Date createTime;

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

    public String getIdentifyingName() {
        return identifyingName;
    }

    public void setIdentifyingName(String identifyingName) {
        this.identifyingName = identifyingName;
    }

    public ManuscriptDTO() {
    }

    public ManuscriptDTO(String id, String contributors, String manuscriptName, String identifyingName, String manuscriptKind, String manuscriptDes, String manuscriptTitle, Integer auditStatus, Date createTime) {
        this.id = id;
        this.contributors = contributors;
        this.manuscriptName = manuscriptName;
        this.identifyingName = identifyingName;
        this.manuscriptKind = manuscriptKind;
        this.manuscriptDes = manuscriptDes;
        this.manuscriptTitle = manuscriptTitle;
        this.auditStatus = auditStatus;
        this.createTime = createTime;
    }
}
