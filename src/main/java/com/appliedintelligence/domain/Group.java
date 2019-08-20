package com.appliedintelligence.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;

import java.util.List;

@PlanningEntity
public class Group {

    private String groupName;
    private int groupIndex;
    private int memberIndex;
    private List<Member> memberList;

    public int getGroupIndex() {
        return groupIndex;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}