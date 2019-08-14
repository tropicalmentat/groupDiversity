package com.appliedintelligence;

import java.util.List;

public class Group {
    /*
    Each business quarter (Accenture calendar) will have a new
    set of groups
     */

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
