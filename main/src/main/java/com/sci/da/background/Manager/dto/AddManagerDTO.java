package com.sci.da.background.Manager.dto;

import java.util.Date;

public class AddManagerDTO {

    private String superManagerAccount;

    private String managerId;

    private String managerAccount;

    private String managerPassword;

    private Integer authority;

    private Date createTime;

    public String getSuperManagerAccount() {
        return superManagerAccount;
    }

    public void setSuperManagerAccount(String superManagerAccount) {
        this.superManagerAccount = superManagerAccount;
    }

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

    public AddManagerDTO() {
        super();
    }

    public AddManagerDTO(String superManagerAccount, String managerId, String managerAccount, String managerPassword, Integer authority, Date createTime) {
        this.superManagerAccount = superManagerAccount;
        this.managerId = managerId;
        this.managerAccount = managerAccount;
        this.managerPassword = managerPassword;
        this.authority = authority;
        this.createTime = createTime;
    }
}
