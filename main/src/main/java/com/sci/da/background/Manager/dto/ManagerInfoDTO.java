package com.sci.da.background.Manager.dto;


public class ManagerInfoDTO {

    private String managerAccount;

    private String phoneNumber;

    private String email;

    private String title;

    private Integer enableStatus;

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
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

    public ManagerInfoDTO() {
        super();
    }

    public ManagerInfoDTO(String managerAccount, String phoneNumber, String email, String title, Integer enableStatus) {
        this.managerAccount = managerAccount;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.title = title;
        this.enableStatus = enableStatus;
    }
}
