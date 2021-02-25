package com.sci.da.front.User.Dto;

public class UserInfoDTO {

    private String account;

    private String phoneNumber;

    private String email;

    private String title;

    private Integer enableStatus;

    private String school;

    private String professional;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public UserInfoDTO() {
        super();
    }

    public UserInfoDTO(String account, String phoneNumber, String email, String title, Integer enableStatus, String school, String professional) {
        this.account = account;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.title = title;
        this.enableStatus = enableStatus;
        this.school = school;
        this.professional = professional;
    }
}
