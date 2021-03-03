package com.sci.da.background.Manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.background.Manager.entity.ManagerInfo;
import com.sci.da.background.Manager.mapper.ManagerInfoMapper;
import com.sci.da.background.Manager.service.ManagerInfoService;
import com.sci.da.background.Manager.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerInfoServiceImpl extends ServiceImpl<ManagerInfoMapper, ManagerInfo> implements ManagerInfoService {
}
