package com.sci.da.background.Manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.background.Manager.dto.AppealInfoDTO;
import com.sci.da.background.Manager.entity.ManageAppeal;

import java.util.List;

public interface ManageAppealService extends IService<ManageAppeal> {

    List<AppealInfoDTO> getAccountAppealInfo(String option);

    boolean editAppealStatus(AppealInfoDTO appealInfoDTO);

}
