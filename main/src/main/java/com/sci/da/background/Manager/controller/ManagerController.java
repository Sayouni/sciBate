package com.sci.da.background.Manager.controller;


import com.sci.da.background.Manager.dto.AddManagerDTO;
import com.sci.da.background.Manager.dto.ManagerDTO;
import com.sci.da.background.Manager.dto.ManagerInfoDTO;
import com.sci.da.background.Manager.entity.Manager;
import com.sci.da.background.Manager.entity.ManagerInfo;
import com.sci.da.background.Manager.service.ManagerInfoService;
import com.sci.da.background.Manager.service.ManagerService;
import com.sci.da.main.util.LoginResult;
import com.sci.da.main.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/manager")
@Api(tags = "管理员模块")
public class ManagerController {

    @Value("${img.file.managerTitle}")
    private String path;

    private Integer imgSize = 10 * 1024 * 1024;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerInfoService managerInfoService;

    @PostMapping("/login")
    @ApiOperation("管理员/超级管理员登录")
    public ResponseMessage login(ManagerDTO managerDTO) {
        if (StringUtils.isBlank(managerDTO.getManagerAccount()) || StringUtils.isBlank(managerDTO.getManagerPassword())) {
            return ResponseMessage.createByErrorCodeMessage("500", "用户名账号/密码为空");
        }

        if (managerService.checkManagerAccount(managerDTO)) {
            if (!managerService.checkEnableStatus(managerDTO.getManagerAccount())){
                return ResponseMessage.createByErrorMessage("该账户无法启用，请联系超级管理员");
            }
            Manager loginRes = managerService.getLoginManager(managerDTO);
            LoginResult loginResult = new LoginResult();
            loginResult.setAccount(managerDTO.getManagerAccount());
            loginResult.setAuthority(loginRes.getAuthority());
            return ResponseMessage.createBySuccessCodeMessage("登录成功", loginResult);
        }
        return ResponseMessage.createByErrorCodeMessage("500", "账号不存在或用户名密码错误");
    }

    @GetMapping("/getManagerMsg")
    @ApiOperation("获取管理员信息")
    public ResponseMessage getManagerMsg(String managerAccount){
        return ResponseMessage.createBySuccessCodeMessage("查询成功",managerService.getManagerMsg(managerAccount));
    }

    @PostMapping("/addManager")
    @ApiOperation("超级管理员添加管理员")
    public ResponseMessage addManager(AddManagerDTO addManagerDTO) {
        if (managerService.checkManagerAuthority(addManagerDTO.getSuperManagerAccount())) {
            if (StringUtils.isNotBlank(addManagerDTO.getManagerAccount()) ||
                    StringUtils.isNotBlank(addManagerDTO.getManagerPassword())) {
                if (managerService.addManager(addManagerDTO)) {
                    return ResponseMessage.createBySuccess("添加成功");
                }
                return ResponseMessage.createByErrorCodeMessage("500", "账号重复");
            }
            return ResponseMessage.createByErrorCodeMessage("500", "账号或密码为空");
        }
        return ResponseMessage.createByErrorCodeMessage("500", "该管理员无权添加");
    }

    @PutMapping("/updateManagerInfo")
    @ApiOperation("修改管理员信息")
    public ResponseMessage updateManagerInfo(ManagerInfoDTO managerInfoDTO) {
        if (StringUtils.isNotBlank(managerInfoDTO.getManagerAccount())) {
            return ResponseMessage.createBySuccessCodeMessage("修改成功"
                    , managerService.updateManagerInfo(managerInfoDTO));
        }
        return ResponseMessage.createByErrorCodeMessage("500", "账号为空");
    }

    @PutMapping("/superManagement")
    @ApiOperation("超级管理员对管理员操作")
    public ResponseMessage superManagement(String superAccount, ManagerInfoDTO managerInfoDTO) {
        if (StringUtils.isNotBlank(superAccount) || StringUtils.isNotBlank(managerInfoDTO.getManagerAccount())) {
            if (managerService.checkManagerAuthority(superAccount)) {
                if (managerService.superManagement(managerInfoDTO)) {
                    return ResponseMessage.createBySuccessMessage("修改成功");
                }
                return ResponseMessage.createByErrorMessage("修改失败");
            }
            return ResponseMessage.createByErrorCodeMessage("500", "权限不足");
        }
        return ResponseMessage.createByErrorCodeMessage("500", "超管账号/管理员账号为空");
    }

    @PostMapping(value = "/uploadManagerTitle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("上传头像")
    public ResponseMessage uploadManagerTitle(HttpServletRequest request,
                                           @RequestParam(value = "managerAccount", required = false) String managerAccount,
                                           @RequestParam(value = "file", required = false) MultipartFile file) {

        if (!managerService.checkExistAccount(managerAccount)){
            return ResponseMessage.createByErrorMessage("错误,账号不存在");
        }
        if (file.isEmpty()) {
            return ResponseMessage.createByErrorMessage("图片为空");
        } else if (file.getSize() > imgSize) {
            return ResponseMessage.createByErrorMessage("图片过大");
        } else {
            String fileName;
            String filePath = path;
            fileName = "管理员" + managerAccount + "_title.jpg";
            File dest = new File(filePath + "/" + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ManagerInfo managerInfo = ManagerInfo.builder().build();
            managerInfo.setManagerAccount(managerAccount);
            managerInfo.setTitle(filePath + "/" +fileName);
            managerInfoService.saveOrUpdate(managerInfo);
            return ResponseMessage.createBySuccessMessage("上传成功");
        }
    }

}
