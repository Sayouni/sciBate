package com.sci.da.background.Manager.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.background.Manager.dto.AppealInfoDTO;
import com.sci.da.background.Manager.entity.ManageAppeal;
import com.sci.da.background.Manager.mapper.ManageAppealMapper;
import com.sci.da.background.Manager.service.ManageAppealService;
import com.sci.da.front.User.entity.AccountAppeal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManageAppealServiceImpl extends ServiceImpl<ManageAppealMapper, ManageAppeal> implements ManageAppealService {



    @Override
    public List<AppealInfoDTO> getAccountAppealInfo(String option) {
        List<AppealInfoDTO> resList = baseMapper.getAccountAppealInfo(option);
        return resList;
    }

    @Override
    @Transactional
    public boolean editAppealStatus(AppealInfoDTO appealInfoDTO) {
        ManageAppeal manageAppeal = ManageAppeal.builder().id(appealInfoDTO.getId())
                .handleStatus(1).build();
        if (saveOrUpdate(manageAppeal)){
            return true;
        }
        return false;
    }
}
