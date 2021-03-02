package com.sci.da.background.Manager.dto;


import java.util.Date;

public class ManagerDTO {

    private String managerId;

    private String managerAccount;

    private String managerPassword;

    private Integer authority;

    private Date createTime;

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

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
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

    public ManagerDTO() {
        super();
    }

    public ManagerDTO(String managerId, String managerAccount, String managerPassword, Integer authority, Date createTime) {
        this.managerId = managerId;
        this.managerAccount = managerAccount;
        this.managerPassword = managerPassword;
        this.authority = authority;
        this.createTime = createTime;
    }
}
