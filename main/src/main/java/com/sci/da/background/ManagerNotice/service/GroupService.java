package com.sci.da.background.ManagerNotice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.background.ManagerNotice.dto.GroupCenterDTO;
import com.sci.da.background.ManagerNotice.dto.GroupCenterMsgDTO;
import com.sci.da.background.ManagerNotice.entity.GroupCenter;

public interface GroupService extends IService<GroupCenter> {

    boolean addGroup(GroupCenterDTO groupCenterDTO);

    boolean checkGroupName(String groupName);

    boolean addMembers(GroupCenterDTO groupCenterDTO);

    IPage<GroupCenterMsgDTO> getGroupCenterMsg(Page page, String groupName);

}
