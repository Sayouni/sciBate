package com.sci.da.background.Manager.dto;

import java.util.Date;

public class ManagerMsgDTO {

    private String managerId;

    private String managerAccount;

    private Integer authority;

    private Date createTime;

    private String phoneNumber;

    private String email;

    private String title;

    private Integer enableStatus;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
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

    public ManagerMsgDTO() {
        super();
    }

    public ManagerMsgDTO(String managerId, String managerAccount, Integer authority, Date createTime, String phoneNumber, String email, String title, Integer enableStatus) {
        this.managerId = managerId;
        this.managerAccount = managerAccount;
        this.authority = authority;
        this.createTime = createTime;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.title = title;
        this.enableStatus = enableStatus;
    }
}
