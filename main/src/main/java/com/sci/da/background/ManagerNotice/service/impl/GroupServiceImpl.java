package com.sci.da.background.ManagerNotice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.background.ManagerNotice.dto.GroupCenterDTO;
import com.sci.da.background.ManagerNotice.dto.GroupCenterMsgDTO;
import com.sci.da.background.ManagerNotice.entity.GroupCenter;
import com.sci.da.background.ManagerNotice.mapper.GroupMapper;
import com.sci.da.background.ManagerNotice.service.GroupService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.main.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupCenter> implements GroupService {

    @Value("${snowflake.worker.id}")
    private Long workerId;
    @Value("${snowflake.data.center.id}")
    private Long dataCenterId;

    @Override
    public boolean addGroup(GroupCenterDTO groupCenterDTO) {
        String saveId = String.valueOf(IdUtil.getId(workerId,dataCenterId));
        if (groupCenterDTO.getMemberList().size()>0) {
            List<GroupCenter> resList = new ArrayList<>();
            for (String id : groupCenterDTO.getMemberList()) {

                GroupCenter group  = GroupCenter.builder().id(saveId)
                        .groupName(groupCenterDTO.getGroupName())
                        .groupMember(id)
                        .build();
                resList.add(group);
            }
            if (saveOrUpdateBatch(resList)){
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean checkGroupName(String groupName) {
        List<GroupCenter> nameList = baseMapper.selectList(null);
        List<String> temp = new ArrayList<>();
        for (GroupCenter groupCenter : nameList){
            temp.add(groupCenter.getGroupName());
        }
        if (temp.contains(groupName)){
            return true;
        }
        return false;
    }

    @Override
    public boolean addMembers(GroupCenterDTO groupCenterDTO) {
        if (groupCenterDTO.getMemberList().size()>0) {
            List<GroupCenter> resList = new ArrayList<>();
            for (String id : groupCenterDTO.getMemberList()) {
                GroupCenter group  = GroupCenter.builder().id(groupCenterDTO.getId())
                        .groupName(groupCenterDTO.getGroupName())
                        .groupMember(id)
                        .build();
                resList.add(group);
            }
            if (saveBatch(resList)){
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public IPage<GroupCenterMsgDTO> getGroupCenterMsg(Page page, String groupName) {
        List<ManuscriptDTO> resList = baseMapper.getGroupCenterMsg(page,groupName);
        page.setRecords(resList);
        return page;

    }

    @Override
    public boolean deleteMembers(List<String> accountList,String id) {
        if (baseMapper.deleteMembers(accountList,id)){
            return true;
        }
        return false;
    }
}
