package com.sci.da.background.Manager.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Manager implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "管理员ID")
    @TableId(value = "manager_id", type = IdType.ID_WORKER_STR)
    private String managerId;

    @ApiModelProperty(value = "登录名")
    private String managerAccount;

    @ApiModelProperty(value = "密码")
    private String managerPassword;

    @ApiModelProperty(value = "权限:1.管理员 2.超级管理员")
    private Integer authority;

    private Date createTime;
}
