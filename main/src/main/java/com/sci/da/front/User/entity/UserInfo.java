package com.sci.da.front.User.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Builder
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "account",type = IdType.ID_WORKER_STR)
    private String account;

    private String phoneNumber;

    private String email;

    private String title;

    private Integer enableStatus;

    private String school;

    private String professional;

}
