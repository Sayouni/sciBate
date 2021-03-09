package com.sci.da.background.ManagerNotice.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@TableName("GROUP_CENTER")
public class GroupCenter implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String groupName;

    private String groupMember;
}
