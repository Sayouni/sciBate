package com.sci.da.background.ManagerNotice.controller;


import com.sci.da.background.ManagerNotice.dto.GroupCenterDTO;
import com.sci.da.background.ManagerNotice.service.GroupService;
import com.sci.da.background.ManagerNotice.service.ManagerNoticeService;
import com.sci.da.main.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manageNotice")
@Api(tags = "通知中心")
public class ManagerNoticeController {

    @Autowired
    private ManagerNoticeService managerNoticeService;

    @Autowired
    private GroupService groupService;

    @PostMapping("/addGroup")
    @ApiOperation("创建分组")
    public ResponseMessage addGroup(GroupCenterDTO groupCenterDTO) {
        if (StringUtils.isNotBlank(groupCenterDTO.getGroupName())) {
            if (!groupService.checkGroupName(groupCenterDTO.getGroupName())) {
                return ResponseMessage.createBySuccessCodeMessage("创建成功", groupService.addGroup(groupCenterDTO));
            }
            return ResponseMessage.createByErrorMessage("分组名称已存在");
        }
        return ResponseMessage.createByErrorMessage("错误,组名不能为空");
    }

    @PostMapping("/addMembers")
    @ApiOperation("添加角色")
    public ResponseMessage addMembers(GroupCenterDTO groupCenterDTO){
        if (StringUtils.isNotBlank(groupCenterDTO.getGroupName())) {
                return ResponseMessage.createBySuccessCodeMessage("添加成功", groupService.addMembers(groupCenterDTO));
            }
        return ResponseMessage.createByErrorMessage("错误,组名不能为空");
    }


}
