package com.sci.da.background.ManagerNotice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.background.ManagerNotice.dto.GroupCenterDTO;
import com.sci.da.background.ManagerNotice.entity.GroupCenter;

public interface GroupService extends IService<GroupCenter> {

    boolean addGroup(GroupCenterDTO groupCenterDTO);

    boolean checkGroupName(String groupName);

    boolean addMembers(GroupCenterDTO groupCenterDTO);

}
