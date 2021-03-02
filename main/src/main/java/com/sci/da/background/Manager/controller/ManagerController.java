package com.sci.da.background.Manager.controller;


import com.sci.da.background.Manager.dto.AddManagerDTO;
import com.sci.da.background.Manager.dto.ManagerDTO;
import com.sci.da.background.Manager.entity.Manager;
import com.sci.da.background.Manager.service.ManagerService;
import com.sci.da.main.util.LoginResult;
import com.sci.da.main.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/manager")
@Api(tags = "管理员模块")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/login")
    @ApiOperation("管理员/超级管理员登录")
    public ResponseMessage login(ManagerDTO managerDTO) {
        if (StringUtils.isBlank(managerDTO.getManagerAccount()) || StringUtils.isBlank(managerDTO.getManagerPassword())) {
            return ResponseMessage.createByErrorCodeMessage(500, "用户名账号/密码为空");
        }
        if (managerService.checkManagerAccount(managerDTO)) {
            Manager loginRes = managerService.getLoginManager(managerDTO);
            LoginResult loginResult = new LoginResult();
            loginResult.setAccount(managerDTO.getManagerAccount());
            loginResult.setAuthority(loginRes.getAuthority());
            return ResponseMessage.createBySuccessCodeMessage("登录成功", loginResult);
        }
        return ResponseMessage.createByErrorCodeMessage(500, "账号不存在或用户名密码错误");
    }

    @PostMapping("/addManager")
    @ApiOperation("/超级管理员添加管理员")
    public ResponseMessage addManager(AddManagerDTO addManagerDTO) {
        if (managerService.checkManagerAuthority(addManagerDTO)) {
            if (StringUtils.isNotBlank(addManagerDTO.getManagerAccount()) ||
                    StringUtils.isNotBlank(addManagerDTO.getManagerPassword())) {
                if (managerService.addManager(addManagerDTO)) {
                    return ResponseMessage.createBySuccess("添加成功");
                }
                return ResponseMessage.createByErrorCodeMessage(500,"账号重复");
            }
            return ResponseMessage.createByErrorCodeMessage(500,"账号或密码为空");
        }
        return ResponseMessage.createByErrorCodeMessage(500, "该管理员无权添加");
    }

}
