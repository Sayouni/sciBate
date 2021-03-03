package com.sci.da.background.Manager.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class ManagerInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "管理员账号")
    @TableId(value = "manager_account", type = IdType.ID_WORKER_STR)
    private String managerAccount;

    @ApiModelProperty(value = "电话")
    private String phoneNumber;

    @ApiModelProperty(value = "邮箱")
    private String email;

    private String title;

    @ApiModelProperty(value = "1:启用 0:禁用")
    private Integer enableStatus;
}
