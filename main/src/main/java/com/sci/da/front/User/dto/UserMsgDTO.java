package com.sci.da.front.User.dto;

import java.util.Date;

public class UserMsgDTO {

    private String userId;

    private String userLoginName;

    private String userLoginPwd;

    private Date createTime;

    private String phoneNumber;

    private String email;

    private String title;

    private Integer enableStatus;

    private String school;

    private String professional;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public UserMsgDTO() {
        super();
    }

    public UserMsgDTO(String userId, String userLoginName, String userLoginPwd, Date createTime, String phoneNumber, String email, String title, Integer enableStatus, String school, String professional) {
        this.userId = userId;
        this.userLoginName = userLoginName;
        this.userLoginPwd = userLoginPwd;
        this.createTime = createTime;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.title = title;
        this.enableStatus = enableStatus;
        this.school = school;
        this.professional = professional;
    }
}
