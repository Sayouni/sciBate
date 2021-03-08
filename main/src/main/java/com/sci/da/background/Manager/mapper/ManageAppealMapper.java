package com.sci.da.background.Manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sci.da.background.Manager.dto.AppealInfoDTO;
import com.sci.da.background.Manager.entity.ManageAppeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManageAppealMapper extends BaseMapper<ManageAppeal> {

    List<AppealInfoDTO> getAccountAppealInfo(@Param("option") String option);

}
