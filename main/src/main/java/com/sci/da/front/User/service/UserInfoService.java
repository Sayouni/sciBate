package com.sci.da.front.User.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.User.dto.UserMsgDTO;
import com.sci.da.front.User.entity.UserInfo;

import java.util.List;


public interface UserInfoService extends IService<UserInfo> {

    boolean checkEnableStatus(String account);

    List<UserMsgDTO> getUserInfoList(String account);

    boolean editUserInfo(UserMsgDTO userMsgDTO);

}
