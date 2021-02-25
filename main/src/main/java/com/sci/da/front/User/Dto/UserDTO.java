package com.sci.da.front.User.Dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sci.da.front.User.entity.SciUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

public class UserDTO{

    private String userId;

    private String userLoginName;

    private String userLoginPwd;

    private Date createTime;

    public UserDTO() {
        super();
    }

    public UserDTO(String userId, String userLoginName, String userLoginPwd, Date createTime) {
        this.userId = userId;
        this.userLoginName = userLoginName;
        this.userLoginPwd = userLoginPwd;
        this.createTime = createTime;
    }

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
}
