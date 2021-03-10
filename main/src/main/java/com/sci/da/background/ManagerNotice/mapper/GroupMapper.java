package com.sci.da.background.ManagerNotice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.background.ManagerNotice.entity.GroupCenter;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapper extends BaseMapper<GroupCenter> {


    List<ManuscriptDTO> getGroupCenterMsg(Page page, String groupName);

    boolean deleteMembers(@Param("accountList") List<String> accountList,@Param("id") String id);

}
