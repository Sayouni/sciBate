package com.sci.da.background.Manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sci.da.background.Manager.dto.ManagerMsgDTO;
import com.sci.da.background.Manager.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper extends BaseMapper<Manager> {

    ManagerMsgDTO getManagerMsg(@Param("managerAccount") String managerAccount);
}
