package com.sci.da.front.User.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.User.entity.UserInfo;


public interface UserInfoService extends IService<UserInfo> {

    boolean checkEnableStatus(String account);
}
