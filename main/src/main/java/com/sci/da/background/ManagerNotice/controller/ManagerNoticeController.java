package com.sci.da.background.ManagerNotice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.background.ManagerNotice.dto.GroupCenterDTO;
import com.sci.da.background.ManagerNotice.dto.GroupCenterMsgDTO;
import com.sci.da.background.ManagerNotice.service.GroupService;
import com.sci.da.background.ManagerNotice.service.ManagerNoticeService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.main.util.ResponseMessage;
import com.sci.da.main.util.ResponseTable;
import com.sci.da.main.util.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getGroupCenterMsg")
    @ApiOperation("获取分组列表")
    public ResponseTable getGroupCenterMsg(String groupName,Integer page,Integer limit){
        IPage<GroupCenterMsgDTO> result = groupService.getGroupCenterMsg(new Page<>(
                page,limit), groupName);
        return TableResult.success("200", "查询成功", (int) result.getTotal(), result.getRecords());
    }


}
