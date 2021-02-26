package com.sci.da.front.Msg.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Manuscript {


    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String contributors;

    private String manuscriptName;

    private String manuscriptKind;

    private String manuscriptDes;

    private String manuscriptTitle;

    private Integer auditStatus;

    private Date createTime;

}
