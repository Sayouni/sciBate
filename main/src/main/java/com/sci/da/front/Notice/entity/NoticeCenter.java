package com.sci.da.front.Notice.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class NoticeCenter implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String noticeTitle;

    private String noticeDetail;

    private Integer readStatus;

    private String publishManager;

    private String delFlag;

    private Date createTime;
}
