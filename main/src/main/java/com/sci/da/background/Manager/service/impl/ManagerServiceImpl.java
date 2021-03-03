package com.sci.da.background.Manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.background.Manager.dto.AddManagerDTO;
import com.sci.da.background.Manager.dto.ManagerDTO;
import com.sci.da.background.Manager.dto.ManagerInfoDTO;
import com.sci.da.background.Manager.entity.Manager;
import com.sci.da.background.Manager.entity.ManagerInfo;
import com.sci.da.background.Manager.mapper.ManagerMapper;
import com.sci.da.background.Manager.service.ManagerInfoService;
import com.sci.da.background.Manager.service.ManagerService;
import com.sci.da.main.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {


    @Value("${snowflake.worker.id}")
    private Long workerId;
    @Value("${snowflake.data.center.id}")
    private Long dataCenterId;

    @Autowired
    private ManagerInfoService managerInfoService;

    @Override
    public boolean checkManagerAccount(ManagerDTO managerDTO) {
        String accountColumn = "manager_account";
        List<Manager> managerList = baseMapper.selectList(new QueryWrapper<Manager>().
                in(accountColumn, managerDTO.getManagerAccount()));
        if (managerList.size() <= 0) {
            return false;
        }
        for (Manager manager : managerList) {
            String md5Password = MD5.create().digestHex16(managerDTO.getManagerPassword());
            if (manager.getManagerPassword().contains(md5Password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Manager getLoginManager(ManagerDTO managerDTO) {
        String accountColumn = "manager_account";
        Manager manager = baseMapper.selectOne(new QueryWrapper<Manager>().
                eq(accountColumn, managerDTO.getManagerAccount()));
        return manager;
    }

    @Override
    public boolean checkManagerAuthority(AddManagerDTO addManagerDTO) {
        String accountColumn = "manager_account";
        Integer superManagerAuthority = 2;
        Manager manager = baseMapper.selectOne(new QueryWrapper<Manager>().
                eq(accountColumn, addManagerDTO.getSuperManagerAccount()));
        if (manager.getAuthority().equals(superManagerAuthority)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addManager(AddManagerDTO addManagerDTO) {
        String accountColumn = "manager_account";
        List<Manager> managerList = baseMapper.selectList(new QueryWrapper<Manager>().in(accountColumn,
                addManagerDTO.getManagerAccount()));
        List<String> accountList = new ArrayList<>();
        for (Manager manager : managerList){
            accountList.add(manager.getManagerAccount());
        }
        if (accountList.contains(addManagerDTO.getManagerAccount())){
           return false;
        }
        Manager manager = Manager.builder().managerId(String.valueOf(IdUtil.getId(workerId,dataCenterId)))
                .managerAccount(addManagerDTO.getManagerAccount())
                .managerPassword(MD5.create().digestHex16(addManagerDTO.getManagerPassword()))
                .build();
        if (save(manager)){
            return true;
        }
        return false;
    }

    @Override
    public void updateManagerInfo(ManagerInfoDTO managerInfoDTO) {
        ManagerInfo managerInfo = ManagerInfo.builder().build();
        BeanUtil.copyProperties(managerInfoDTO,managerInfo);
        managerInfoService.saveOrUpdate(managerInfo);
    }
}
