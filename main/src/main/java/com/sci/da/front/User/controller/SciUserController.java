package com.sci.da.front.User.controller;


import com.sci.da.front.User.dto.UserDTO;
import com.sci.da.front.User.dto.UserInfoDTO;
import com.sci.da.front.User.service.SciUserService;
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
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tianyuankuan
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/sci-user")
@Api(tags = "用户模块")
public class SciUserController {

    @Value("${img.file.userTitle}")
    private String path;

    private Integer imgSize = 10 * 1024 * 1024;

    @Autowired
    private SciUserService service;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseMessage login( UserDTO userDTO) {
        if (StringUtils.isBlank(userDTO.getUserLoginName()) || StringUtils.isBlank(userDTO.getUserLoginPwd())) {
            return ResponseMessage.createByErrorCodeMessage(500, "用户名密码为空");
        }

        if (service.checkUser(userDTO)) {
            if (!service.checkEnableStatus(userDTO.getUserLoginName())){
                return ResponseMessage.createByErrorMessage("该账号已被封禁，请申诉");
            }
            LoginResult loginResult = new LoginResult();
            loginResult.setAccount(userDTO.getUserLoginName());
            loginResult.setStatus("1");
            return ResponseMessage.createBySuccessCodeMessage("登录成功", loginResult);
        } else {
            return ResponseMessage.createByErrorCodeMessage(500, "账号不存在或用户名密码错误");
        }
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public ResponseMessage register(UserDTO userDTO) {
        if (StringUtils.isBlank(userDTO.getUserLoginName()) || StringUtils.isBlank(userDTO.getUserLoginPwd())) {
            return ResponseMessage.createByErrorCodeMessage(500, "注册用户名密码为空");
        }

        if (service.registerUser(userDTO)) {
            return ResponseMessage.createBySuccess("注册成功");
        }
        return ResponseMessage.createByErrorCodeMessage(500, "用户名重复");
    }

    @PostMapping("/accountAppeal")
    @ApiOperation("账号申诉")
    public ResponseMessage accountAppeal(String account) {
        if (StringUtils.isNotBlank(account)) {
            if (service.checkExistAccount(account)) {
                service.sendAccountAppeal(account);
                return ResponseMessage.createBySuccessMessage("发送申诉成功");
            }
        }
        return ResponseMessage.createByErrorCodeMessage(500, "账号为空");
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public ResponseMessage getUserInfo(String account){
        return ResponseMessage.createBySuccessCodeMessage("查询成功",service.getUserInfo(account));
    }

    @PutMapping("/updateUserInfo")
    @ApiOperation("个人信息修改")
    public ResponseMessage updateUserInfo(UserInfoDTO userInfoDTO) {
        if (StringUtils.isBlank(userInfoDTO.getAccount())) {
            return ResponseMessage.createByErrorCodeMessage(500, "错误，账号为空！");
        }
        if (!service.checkExistAccount(userInfoDTO.getAccount())) {
            return ResponseMessage.createByErrorMessage("错误，该账号不存在");
        } else {
            service.saveOrUpdateUserInfo(userInfoDTO);
            return ResponseMessage.createBySuccessMessage("用户信息更新成功");
        }
    }

    @PostMapping(value = "/materialPicture", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("上传头像")
    public ResponseMessage uploadUserTitle(HttpServletRequest request,
                                           @RequestParam(value = "account", required = false) String account,
                                           @RequestParam(value = "file", required = false) MultipartFile file) {

        if (!service.checkExistAccount(account)){
            return ResponseMessage.createByErrorMessage("错误,账号不存在");
        }
        if (file.isEmpty()) {
            return ResponseMessage.createByErrorMessage("图片为空");
        } else if (file.getSize() > imgSize) {
            return ResponseMessage.createByErrorMessage("图片过大");
        } else {
            String fileName;
            String filePath = path;
            fileName = "用户" + account + "_title.jpg";
            File dest = new File(filePath + "/" + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            UserInfoDTO userInfo = new UserInfoDTO();
            userInfo.setAccount(account);
            userInfo.setTitle(filePath + "/" + fileName);
            service.saveOrUpdateUserInfo(userInfo);
            return ResponseMessage.createBySuccessMessage("上传成功");
        }
    }

}

