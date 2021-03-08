package com.sci.da.background.Manager.controller;

import com.sci.da.front.User.dto.UserMsgDTO;
import com.sci.da.front.User.service.UserInfoService;
import com.sci.da.main.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managerUser")
@Api(tags = "用户管理模块")
public class ManageUserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUserInfoList")
    @ApiOperation("检索用户信息列表")
    public ResponseMessage getUserInfoList(String account) {
        return ResponseMessage.createBySuccessCodeMessage("检索成功", userInfoService.getUserInfoList(account));
    }

    @PutMapping("/editUserInfo")
    @ApiOperation("修改用户信息")
    public ResponseMessage editUserInfo(UserMsgDTO userMsgDTO) {
        if (StringUtils.isNotBlank(userMsgDTO.getUserId()) && StringUtils.isNotBlank(userMsgDTO.getUserLoginName())) {
            if (userInfoService.editUserInfo(userMsgDTO)){
                return ResponseMessage.createBySuccess("修改成功");
            }
                return ResponseMessage.createByErrorMessage("修改失败");
        }
        return ResponseMessage.createByErrorMessage("参数为空");
    }


}
