package com.sci.da.front.User.service.Impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.User.dto.UserMsgDTO;
import com.sci.da.front.User.entity.SciUser;
import com.sci.da.front.User.entity.UserInfo;
import com.sci.da.front.User.mapper.UserInfoMapper;
import com.sci.da.front.User.service.SciUserService;
import com.sci.da.front.User.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private SciUserService sciUserService;

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

    @Override
    @Transactional
    public boolean editUserInfo(UserMsgDTO userMsgDTO) {
        if (StringUtils.isNotBlank(userMsgDTO.getUserLoginPwd())){
            SciUser sciUser = SciUser.builder()
                    .userId(userMsgDTO.getUserId())
                    .userLoginPwd(MD5.create().digestHex16(userMsgDTO.getUserLoginPwd())).build();
            if (!sciUserService.saveOrUpdate(sciUser)){
                return false;
            }
        }
        UserInfo userInfo = UserInfo.builder()
                .account(userMsgDTO.getUserLoginName())
                .email(userMsgDTO.getEmail())
                .phoneNumber(userMsgDTO.getPhoneNumber())
                .school(userMsgDTO.getSchool())
                .professional(userMsgDTO.getProfessional())
                .enableStatus(userMsgDTO.getEnableStatus())
                .build();
        if (saveOrUpdate(userInfo)){
            return true;
        }
        return false;
    }
}
