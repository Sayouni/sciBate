package com.sci.da.background.ManagerNotice.dto;

import com.sci.da.front.User.entity.UserInfo;

import java.util.List;

public class GroupCenterMsgDTO {

    private String id;

    private String groupName;

    private String groupMember;

    private List<UserInfo> userInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public GroupCenterMsgDTO() {
        super();
    }

    public GroupCenterMsgDTO(String id, String groupName, String groupMember, List<UserInfo> userInfoList) {
        this.id = id;
        this.groupName = groupName;
        this.groupMember = groupMember;
        this.userInfoList = userInfoList;
    }
}
