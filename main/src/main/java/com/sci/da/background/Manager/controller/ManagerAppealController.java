package com.sci.da.background.Manager.controller;


import com.sci.da.background.Manager.service.ManageAppealService;
import com.sci.da.main.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manageAppeal")
@Api(tags = "申诉管理模块")
public class ManagerAppealController {

    @Autowired
    private ManageAppealService manageAppealService;

    @GetMapping("/getAccountAppealInfo")
    @ApiOperation(value = "获取申诉信息")
    public ResponseMessage getAccountAppealInfo(String option){
        return ResponseMessage.createBySuccessCodeMessage("查询成功",manageAppealService.getAccountAppealInfo(option));
    }

}
