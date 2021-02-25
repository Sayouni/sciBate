package com.sci.da.front.User.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import com.sci.da.front.User.Dto.UserDTO;
import com.sci.da.front.User.Dto.UserInfoDTO;
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


    @Override
    public boolean checkUser(UserDTO userDTO) {
        List<SciUser> res = baseMapper.selectList(null);
        Map<String,String> temp = new HashMap<>();
        for (SciUser user : res){
            temp.put(user.getUserLoginName(),user.getUserLoginPwd());
        }
        if (StringUtils.isNotBlank(temp.get(userDTO.getUserLoginName()))){
            String md5Value = MD5.create().digestHex(userDTO.getUserLoginPwd());
            if (temp.get(userDTO.getUserLoginName()).equals(md5Value)){
                return true;
            }
        }
        return false;
    }

    @Override
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
            sciUser.setUserLoginPwd(MD5.create().digestHex(sciUser.getUserLoginPwd()));
            baseMapper.insert(sciUser);
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
    public void sendAccountAppeal(String account) {
        AccountAppeal accountAppeal = AccountAppeal.builder()
                .id(String.valueOf(IdUtil.getId(workerId,dataCenterId)))
                .account(account)
                .build();
        accountAppealService.saveAccountAppeal(accountAppeal);
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
}
