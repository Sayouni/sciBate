package com.sci.da.front.User.service;

import com.sci.da.front.User.dto.UserDTO;
import com.sci.da.front.User.dto.UserInfoDTO;
import com.sci.da.front.User.entity.SciUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.User.entity.UserInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianyuankuan
 * @since 2021-02-01
 */
public interface SciUserService extends IService<SciUser> {

    boolean checkUser(UserDTO userDTO);

    boolean registerUser(UserDTO userDTO);

    boolean checkExistAccount(String account);

    void sendAccountAppeal(String account);

    void saveOrUpdateUserInfo(UserInfoDTO userInfoDTO);

    boolean checkEnableStatus(String account);

    UserInfo getUserInfo(String account);

}
