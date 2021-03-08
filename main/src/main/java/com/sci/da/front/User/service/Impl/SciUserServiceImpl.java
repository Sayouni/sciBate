package com.sci.da.front.User.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sci.da.background.Manager.entity.ManageAppeal;
import com.sci.da.background.Manager.service.ManageAppealService;
import com.sci.da.front.User.dto.UserDTO;
import com.sci.da.front.User.dto.UserInfoDTO;
import com.sci.da.front.User.dto.UserMsgDTO;
import com.sci.da.front.User.entity.AccountAppeal;
import com.sci.da.front.User.entity.SciUser;
import com.sci.da.front.User.entity.UserInfo;
import com.sci.da.front.User.mapper.SciUserMapper;
import com.sci.da.front.User.service.AccountAppealService;
import com.sci.da.front.User.service.SciUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.User.service.UserInfoService;
import com.sci.da.main.util.IdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianyuankuan
 * @since 2021-02-01
 */
@Service
public class SciUserServiceImpl extends ServiceImpl<SciUserMapper, SciUser> implements SciUserService {

    @Value("${snowflake.worker.id}")
    private Long workerId;
    @Value("${snowflake.data.center.id}")
    private Long dataCenterId;

    @Autowired
    private AccountAppealService accountAppealService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ManageAppealService manageAppealService;


    @Override
    public boolean checkUser(UserDTO userDTO) {
        List<SciUser> res = baseMapper.selectList(null);
        Map<String,String> temp = new HashMap<>();
        for (SciUser user : res){
            temp.put(user.getUserLoginName(),user.getUserLoginPwd());
        }
        if (StringUtils.isNotBlank(temp.get(userDTO.getUserLoginName()))){
            String md5Value = MD5.create().digestHex16(userDTO.getUserLoginPwd());
            if (temp.get(userDTO.getUserLoginName()).equals(md5Value)){
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean registerUser(UserDTO userDTO) {
        //校验账号重复性
        List<SciUser> res = baseMapper.selectList(null);
        List<String> accountList = new ArrayList<>();
        for (SciUser user : res){
            accountList.add(user.getUserLoginName());
        }
        if (accountList.contains(userDTO.getUserLoginName())){
            return false;
        }else {
            SciUser sciUser = SciUser.builder()
                    .userId(String.valueOf(IdUtil.getId(workerId,dataCenterId)))
                    .build();
            BeanUtil.copyProperties(userDTO,sciUser);
            sciUser.setUserLoginPwd(MD5.create().digestHex16(sciUser.getUserLoginPwd()));
            baseMapper.insert(sciUser);
            UserInfo userInfo = UserInfo.builder().account(sciUser.getUserLoginName()).build();
            userInfoService.save(userInfo);
            return true;
        }
    }

    @Override
    public boolean checkExistAccount(String account) {
        List<String> accountList = baseMapper.selectAccounts();
        if (accountList.contains(account)){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void sendAccountAppeal(AccountAppeal accountAppeal) {
        accountAppeal.setId(String.valueOf(IdUtil.getId(workerId,dataCenterId)));
        accountAppealService.saveAccountAppeal(accountAppeal);
        ManageAppeal manageAppeal = ManageAppeal.builder().id(String.valueOf(IdUtil.getId(workerId,dataCenterId)))
                .appealId(accountAppeal.getId()).build();
        manageAppealService.save(manageAppeal);
    }

    @Override
    public void saveOrUpdateUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = UserInfo.builder().build();
        BeanUtil.copyProperties(userInfoDTO,userInfo);
        userInfoService.saveOrUpdate(userInfo);
    }

    @Override
    public boolean checkEnableStatus(String account) {
        if(userInfoService.checkEnableStatus(account)){
            return true;
        }
        return false;
    }

    @Override
    public UserMsgDTO getUserInfo(String account) {
        UserMsgDTO userMsgDTO = baseMapper.getUserInfo(account);
        return userMsgDTO;
    }
}
