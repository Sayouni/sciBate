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
public class ManageAppeal implements Serializable {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String appealId;

    private Integer handleStatus;

    private Date createTime;
}
