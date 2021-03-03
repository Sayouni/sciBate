package com.sci.da.background.Manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.background.Manager.dto.AddManagerDTO;
import com.sci.da.background.Manager.dto.ManagerDTO;
import com.sci.da.background.Manager.dto.ManagerInfoDTO;
import com.sci.da.background.Manager.entity.Manager;

public interface ManagerService extends IService<Manager> {


    boolean checkManagerAccount(ManagerDTO managerDTO);

    Manager getLoginManager(ManagerDTO managerDTO);

    boolean checkManagerAuthority(AddManagerDTO addManagerDTO);

    boolean addManager(AddManagerDTO addManagerDTO);

    void updateManagerInfo(ManagerInfoDTO managerInfoDTO);

}
