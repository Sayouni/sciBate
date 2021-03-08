package com.sci.da.front.User.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.User.dto.UserMsgDTO;
import com.sci.da.front.User.entity.UserInfo;
import com.sci.da.front.User.mapper.UserInfoMapper;
import com.sci.da.front.User.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public boolean checkEnableStatus(String account) {
        if (baseMapper.checkStatus(account) == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<UserMsgDTO> getUserInfoList(String account) {

        List<UserMsgDTO> resList = baseMapper.getUserInfoList(account);
        if (resList.size()<=0){
            return null;
        }
        return resList;
    }
}
