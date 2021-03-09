package com.sci.da.background.ManagerNotice.dto;

import java.util.List;

public class GroupCenterDTO {

    private String id;

    private String groupName;

    private String groupMember;

    private List<String> memberList;

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

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }

    public GroupCenterDTO() {
        super();
    }

    public GroupCenterDTO(String id, String groupName, String groupMember) {
        this.id = id;
        this.groupName = groupName;
        this.groupMember = groupMember;
    }

    public GroupCenterDTO(String id, String groupName, List<String> memberList) {
        this.id = id;
        this.groupName = groupName;
        this.memberList = memberList;
    }

    public GroupCenterDTO(String id, String groupName, String groupMember, List<String> memberList) {
        this.id = id;
        this.groupName = groupName;
        this.groupMember = groupMember;
        this.memberList = memberList;
    }
}
